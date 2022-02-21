package com.restaurant.restaurantservices.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;

    @Column(length = 20, nullable = false)
    private String restaurantName;

    @Column(length = 20, nullable = false)
    private String restaurantLocation;

    @Column(nullable = false)
    private Double restaurantRating;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantLocation='" + restaurantLocation + '\'' +
                ", restaurantRating=" + restaurantRating +
                ", menus=" + menus +
                '}';
    }
}
