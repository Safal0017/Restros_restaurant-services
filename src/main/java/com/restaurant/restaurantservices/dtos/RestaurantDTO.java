package com.restaurant.restaurantservices.dtos;

public class RestaurantDTO {

    private int restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private Double restaurantRating;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public Double getRestaurantRating() {
        return restaurantRating;
    }

    public void setRestaurantRating(Double restaurantRating) {
        this.restaurantRating = restaurantRating;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantLocation='" + restaurantLocation + '\'' +
                ", restaurantRating=" + restaurantRating +
                '}';
    }
}
