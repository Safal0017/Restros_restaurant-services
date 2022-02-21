package com.restaurant.restaurantservices.dtos;

import com.restaurant.restaurantservices.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private int categoryId;
    private String categoryName;

//    private List<Item> item;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

//    public List<Item> getItem() {
//        return item;
//    }
//
//    public void setItem(List<Item> item) {
//        this.item = item;
//    }


    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
