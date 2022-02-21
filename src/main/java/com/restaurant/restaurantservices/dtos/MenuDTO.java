package com.restaurant.restaurantservices.dtos;

public class MenuDTO {

    private int menuId;
    private RestaurantDTO restaurant;
    private ItemDTO item;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuId=" + menuId +
                ", restaurant=" + restaurant +
                ", item=" + item +
                '}';
    }
}
