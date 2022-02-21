package com.restaurant.restaurantservices.repository;

import com.restaurant.restaurantservices.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
