package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Restaurant;
import com.restaurant.restaurantservices.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(int id, Restaurant restaurant) {
        Restaurant restaurantToBeUpdated = getRestaurantBasedOnId(id);
        restaurantToBeUpdated.setRestaurantName(restaurant.getRestaurantName());
        restaurantToBeUpdated.setRestaurantLocation(restaurant.getRestaurantLocation());
        restaurantToBeUpdated.setRestaurantRating(restaurant.getRestaurantRating());
        Restaurant savedRestaurant = restaurantRepository.save(restaurantToBeUpdated);
        return savedRestaurant;
    }

    @Override
    public Restaurant getRestaurantBasedOnId(int id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public boolean deleteRestaurant(Restaurant restaurant) {
        Restaurant restaurantToBeDeleted = getRestaurantBasedOnId(restaurant.getRestaurantId());
        if(restaurantToBeDeleted == null) {
            return false;
        }
        restaurantRepository.delete(restaurantToBeDeleted);
        return true;
    }
}
