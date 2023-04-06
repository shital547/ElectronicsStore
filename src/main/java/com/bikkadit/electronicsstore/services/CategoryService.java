package com.bikkadit.electronicsstore.services;

import com.bikkadit.electronicsstore.dtos.CategoryDto;
import com.bikkadit.electronicsstore.dtos.PageableResponse;

public interface CategoryService {
    // create
    CategoryDto create (CategoryDto categoryDto);

    // update
    CategoryDto update(CategoryDto categoryDto, Long categoryId);

    // delete
    void delete (Long categoryId);

    // getAll
    PageableResponse<CategoryDto> getAllCategories(int pageNumber, int pageSize, String sortBy, String sortDir);

    // get Single

    CategoryDto getSingleCategory(Long categoryId);

    // search

}
