package com.restaurant.restaurantservices.dtos;

import com.restaurant.restaurantservices.entities.Category;

public class ItemDTO {

    private int itemId;
    private String itemName;
    private int itemPrice;

    private CategoryDTO category;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", category=" + category +
                '}';
    }
}
