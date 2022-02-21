package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(Category category);

    public Category updateCategory(int id, Category category);

    public Category getCategoryBasedOnId(int id);

    public List<Category> getAllCategories();

    public boolean deleteCategory(Category category);

}
