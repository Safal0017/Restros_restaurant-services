package com.restaurant.restaurantservices.entities;


import javax.persistence.*;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private Item item;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", restaurant=" + restaurant +
                ", item=" + item +
                '}';
    }
}
