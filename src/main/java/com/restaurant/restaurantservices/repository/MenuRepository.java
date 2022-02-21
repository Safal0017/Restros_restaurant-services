package com.restaurant.restaurantservices.repository;

import com.restaurant.restaurantservices.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
