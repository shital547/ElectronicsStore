package com.bikkadit.electronicsstore.services;

import com.bikkadit.electronicsstore.dtos.PageableResponse;
import com.bikkadit.electronicsstore.dtos.ProductDto;

import java.util.List;


public interface ProductService {


    // create
    ProductDto create(ProductDto productDto);

    // update
    ProductDto update(ProductDto productDto, String productId);

    //delete
    void delete (String productId);

    // get By single
    ProductDto get(String productId);

    //get by all
    PageableResponse<ProductDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);

    //get by live
    PageableResponse<ProductDto> getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir);

    // search product
    PageableResponse<ProductDto> searchByTitle(String subtitle,int pageNumber, int pageSize, String sortBy, String sortDir);

    //other method
}
