package com.ads.electronic.store.ElectronicStore.controller;

import com.ads.electronic.store.ElectronicStore.dtos.ApiResponseMessage;
import com.ads.electronic.store.ElectronicStore.dtos.CategoryDto;
import com.ads.electronic.store.ElectronicStore.dtos.PageableResponse;
import com.ads.electronic.store.ElectronicStore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto created = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping("/{categoryId}")
    public  ResponseEntity<CategoryDto> updateCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable String categoryId
            ){
        CategoryDto update = categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }
    @DeleteMapping("/{categoryId}")
     public ResponseEntity<ApiResponseMessage> deleteCategory(
             @PathVariable String categoryId
     ){
        categoryService.deleteCategory(categoryId);
        ApiResponseMessage message = ApiResponseMessage.builder().mesaage("category Deleted successFully").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);
     }
     @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(
            @PathVariable String categoryId
     ){
        return new ResponseEntity<>(categoryService.getSingleCategory(categoryId),HttpStatus.OK);
     }
     @GetMapping
    public  ResponseEntity<PageableResponse<CategoryDto>> getAllCategory(
             @RequestParam (value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
             @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
             @RequestParam(value = "sortBy",defaultValue = "title",required = false) String sortBy,
             @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir

     ){
        return new ResponseEntity<>(categoryService.getAllUser(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
     }
}
