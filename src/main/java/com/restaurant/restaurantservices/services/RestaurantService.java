package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(Restaurant restaurant);

    public Restaurant updateRestaurant(int id, Restaurant restaurant);

    public Restaurant getRestaurantBasedOnId(int id);

    public List<Restaurant> getAllRestaurants();

    public boolean deleteRestaurant(Restaurant restaurant);

}
