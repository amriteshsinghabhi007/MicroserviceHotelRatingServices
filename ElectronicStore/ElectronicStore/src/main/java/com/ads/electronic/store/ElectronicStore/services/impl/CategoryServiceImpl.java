package com.ads.electronic.store.ElectronicStore.services.impl;

import com.ads.electronic.store.ElectronicStore.dtos.CategoryDto;
import com.ads.electronic.store.ElectronicStore.dtos.PageableResponse;
import com.ads.electronic.store.ElectronicStore.entity.Category;
import com.ads.electronic.store.ElectronicStore.entity.User;
import com.ads.electronic.store.ElectronicStore.exception.ResourceNotFoundException;
import com.ads.electronic.store.ElectronicStore.helper.HelperMethods;
import com.ads.electronic.store.ElectronicStore.repositories.CategoryRepository;
import com.ads.electronic.store.ElectronicStore.services.CategoryService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        String categoryId = UUID.randomUUID().toString();
        categoryDto.setCategoryId(categoryId);
        Category category = mapper.map(categoryDto,Category.class);
        Category categorySaved = categoryRepository.save(category);
        return mapper.map(categorySaved,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category not found with given userId"));
        category.setTitle(categoryDto.getTitle());
        category.setModel(categoryDto.getModel());

        Category categorySaved = categoryRepository.save(category);
        return mapper.map(categorySaved,CategoryDto.class);
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category not found with given userId to delete"));
        categoryRepository.delete(category);
    }

    @Override
    public PageableResponse<CategoryDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("asc")) ? (Sort.by(sortBy).ascending()) : (Sort.by(sortBy).descending());

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Category> page = categoryRepository.findAll(pageable);

        PageableResponse<CategoryDto> pageableResponse = HelperMethods.getPageableResponse(page,CategoryDto.class);
        return pageableResponse;
    }

    @Override
    public CategoryDto getSingleCategory(String categoryId) {
       Category category =  categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("No category found with this given userID"));
       return mapper.map(category,CategoryDto.class);
    }
}
