package com.restaurant.restaurantservices.controllers;


import com.restaurant.restaurantservices.dtos.RestaurantDTO;
import com.restaurant.restaurantservices.entities.Restaurant;
import com.restaurant.restaurantservices.services.RestaurantService;
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
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ModelMapper modelmapper;

    /**
     * CRUD Operations
     * Create - POST
     * Get restaurant based on it's id - GET
     * Update - PUT
     * Delete - DELETE
     */

    /**
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/restaurants/live
     * @return
     */

    @GetMapping(value = "/restaurants/live" )
    public ResponseEntity checkLive() {
        return new ResponseEntity("Restaurant Service Running Live", HttpStatus.OK);
    }

    /**
     * GET Request
     * get all restaurants
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/restaurants
     */

    @GetMapping(value = "/restaurants")
    public ResponseEntity getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantService.getAllRestaurants();
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        restaurantList.forEach(restaurant -> restaurantDTOList.add(modelmapper.map(restaurant, RestaurantDTO.class)));

        return new ResponseEntity(restaurantDTOList, HttpStatus.OK);
    }

    /**
     * GET Request
     * get single restaurant based on id
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/restaurants/id
     * Example: http://localhost:8080/restaurant_app/v1/restaurants/1
     */

    @GetMapping(value = "/restaurants/{id}")
    public ResponseEntity getRestaurantBasedOnId(@PathVariable(name = "id") int id) {
        Restaurant restaurant = restaurantService.getRestaurantBasedOnId(id);
        RestaurantDTO restaurantDTO = modelmapper.map(restaurant, RestaurantDTO.class);

        return new ResponseEntity(restaurantDTO, HttpStatus.OK);
    }

    /**
     * POST Request
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/restaurants
     * {
     *     "restaurantName": "Ashish",
     *     "restaurantLocation": "Bharuch",
     *     "restaurantRating": 3.5
     * }
     */

    @PostMapping(value = "/restaurants", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant newRestaurant = modelmapper.map(restaurantDTO, Restaurant.class);
        Restaurant savedRestaurant = restaurantService.createRestaurant(newRestaurant);
        RestaurantDTO savedRestaurantDTO = modelmapper.map(savedRestaurant, RestaurantDTO.class);

        return new ResponseEntity(savedRestaurantDTO, HttpStatus.CREATED);
    }

    /**
     * PUT Request
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/restaurants/id
     * Example: http://localhost:8080/restaurant_app/v1/restaurants/1
     */

    @PutMapping(value = "/restaurants/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRestaurant(@PathVariable(name = "id") int id,@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurantToBeUpdated = modelmapper.map(restaurantDTO, Restaurant.class);
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurantToBeUpdated);
        RestaurantDTO updatedRestaurantDTO = modelmapper.map(updatedRestaurant, RestaurantDTO.class);

        return new ResponseEntity(updatedRestaurantDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable(name = "id") int id) {
        Restaurant restaurantToBeDeleted = restaurantService.getRestaurantBasedOnId(id);
        Boolean result = restaurantService.deleteRestaurant(restaurantToBeDeleted);
        String output;
        if(result == true) {
            output = "The restaurant with id "+id+" deleted successfully";
        } else {
            output = "Failed to delete the restaurant with id "+id;
        }

        return new ResponseEntity(output, HttpStatus.OK);
    }

}
