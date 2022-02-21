package com.restaurant.restaurantservices.repository;

import com.restaurant.restaurantservices.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
