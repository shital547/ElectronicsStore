package com.bikkadit.electronicsstore.services.Impl;

import com.bikkadit.electronicsstore.dtos.CategoryDto;
import com.bikkadit.electronicsstore.dtos.PageableResponse;
import com.bikkadit.electronicsstore.entities.Category;
import com.bikkadit.electronicsstore.exceptions.ResourceNotFoundException;
import com.bikkadit.electronicsstore.helper.Helper;
import com.bikkadit.electronicsstore.repositories.CategoryRepo;
import com.bikkadit.electronicsstore.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);

        Category saveCategory = categoryRepo.save(category);

        return mapper.map(saveCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not updated with given Id"));
        category.setDescription(categoryDto.getDescription());
        category.setTitle(category.getTitle());
        category.setCoverImage(category.getCoverImage());
        Category updateCategory = categoryRepo.save(category);
        return mapper.map(updateCategory, CategoryDto.class);
    }

    @Override
    public void delete(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not deleted with given Id"));
        categoryRepo.delete(category);
    }

    @Override
    public PageableResponse<CategoryDto> getAllCategories(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Sort sort = (sortDir.equalsIgnoreCase("desc"))?Sort.by(sortBy).descending():(Sort.by(sortBy).ascending());

        PageableResponse<CategoryDto> pageableResponse = Helper.getPageableResponse(Page.empty(), CategoryDto.class);

        return pageableResponse;

    }

    @Override
    public CategoryDto getSingleCategory(Long categoryId) {

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not Found by given Id"));

        return mapper.map(category, CategoryDto.class);
    }
}
