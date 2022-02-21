package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Category;
import com.restaurant.restaurantservices.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Category categoryToBeUpdated = getCategoryBasedOnId(id);
        categoryToBeUpdated.setCategoryName(category.getCategoryName());
        Category savedCategory = categoryRepository.save(categoryToBeUpdated);

        return savedCategory;
    }

    @Override
    public Category getCategoryBasedOnId(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteCategory(Category category) {
        Category categoryToBeDeleted = getCategoryBasedOnId(category.getCategoryId());
        if(categoryToBeDeleted == null) {
            return false;
        }
        categoryRepository.delete(categoryToBeDeleted);
        return true;
    }
}
