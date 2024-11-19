package com.ads.electronic.store.ElectronicStore.services;

import com.ads.electronic.store.ElectronicStore.dtos.CategoryDto;
import com.ads.electronic.store.ElectronicStore.dtos.PageableResponse;
import org.springframework.stereotype.Service;


public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto categoryDto);
    //update
    CategoryDto updateCategory(CategoryDto categoryDto, String categoryId);
    //delete
    void deleteCategory(String categoryId);
    //get ALL user
    PageableResponse<CategoryDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir);
    //get Single User

    CategoryDto getSingleCategory(String categoryId);
}
