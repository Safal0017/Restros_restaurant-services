package com.restaurant.restaurantservices.repository;

import com.restaurant.restaurantservices.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
