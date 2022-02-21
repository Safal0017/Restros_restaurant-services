package com.restaurant.restaurantservices.controllers;


import com.restaurant.restaurantservices.dtos.CategoryDTO;
import com.restaurant.restaurantservices.entities.Category;
import com.restaurant.restaurantservices.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurant_app/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelmapper;

    /**
     * CRUD Operations
     * Create - POST
     * Get category based on it's id - GET
     * Update - PUT
     * Delete - DELETE
     */

    /**
     * GET Request
     * get all categories
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/categories
     */

    @GetMapping(value = "/categories")
    public ResponseEntity getAllCategories() {
        List<Category> categoryList = categoryService.getAllCategories();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryList.forEach(category -> categoryDTOList.add(modelmapper.map(category, CategoryDTO.class)));

        return new ResponseEntity(categoryDTOList, HttpStatus.OK);
    }

    /**
     * GET Request
     * get single category based on id
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/categories/id
     * Example: http://localhost:8080/restaurant_app/v1/categories/1
     */

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity getCategoryBasedOnId(@PathVariable(name = "id") int id) {
        Category category = categoryService.getCategoryBasedOnId(id);
        CategoryDTO categoryDTO = modelmapper.map(category, CategoryDTO.class);

        return new ResponseEntity(categoryDTO, HttpStatus.OK);
    }

    /**
     * POST Request
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/categories
     * {
     *     "categoryName": "Punjabi"
     * }
     */

    @PostMapping(value = "/categories", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category newCategory = modelmapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryService.createCategory(newCategory);
        CategoryDTO savedCategoryDTO = modelmapper.map(savedCategory, CategoryDTO.class);

        return new ResponseEntity(savedCategoryDTO, HttpStatus.CREATED);
    }

    /**
     * PUT Request
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/categories/id
     * Example: http://localhost:8080/restaurant_app/v1/categories/1
     */

    @PutMapping(value = "/categories/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCategory(@PathVariable(name = "id") int id,@RequestBody CategoryDTO categoryDTO) {
        Category categoryToBeUpdated = modelmapper.map(categoryDTO, Category.class);
        Category updatedCategory = categoryService.updateCategory(id, categoryToBeUpdated);
        CategoryDTO updatedCategoryDTO = modelmapper.map(updatedCategory, CategoryDTO.class);

        return new ResponseEntity(updatedCategoryDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/categories/{id}")
    public ResponseEntity deleteCategory(@PathVariable(name = "id") int id) {
        Category categoryToBeDeleted = categoryService.getCategoryBasedOnId(id);
        Boolean result = categoryService.deleteCategory(categoryToBeDeleted);
        String output;
        if(result == true) {
            output = "The category with id "+id+" deleted successfully";
        } else {
            output = "Failed to delete the category with id "+id;
        }

        return new ResponseEntity(output, HttpStatus.OK);
    }

}
