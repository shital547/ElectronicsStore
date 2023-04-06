package com.bikkadit.electronicsstore.controllers;

import com.bikkadit.electronicsstore.dtos.CategoryDto;
import com.bikkadit.electronicsstore.dtos.PageableResponse;
import com.bikkadit.electronicsstore.helper.ApiResponseMessage;
import com.bikkadit.electronicsstore.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper mapper;

    // create
    @PostMapping
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto categoryDto1 = categoryService.create(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);

    }

    // update

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(@PathVariable("categoryId") Long categoryId, @RequestBody CategoryDto categoryDto) {
        CategoryDto updatecategoryDto = categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<>(updatecategoryDto, HttpStatus.OK);
    }

    // delete

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponseMessage> delete(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
        ApiResponseMessage message = ApiResponseMessage
                .builder().message("Category delete successful !!! ").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // getALl

    @GetMapping
    public ResponseEntity<PageableResponse<CategoryDto>> getAllCategories(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        PageableResponse<CategoryDto> pageableResponse = categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(pageableResponse, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(Long categoryId) {
        CategoryDto getCategoryDto = categoryService.getSingleCategory(categoryId);
        return new ResponseEntity<>(getCategoryDto, HttpStatus.OK);

    }
}