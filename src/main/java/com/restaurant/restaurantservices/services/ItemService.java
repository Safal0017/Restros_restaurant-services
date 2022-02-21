package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Item;

import java.util.List;

public interface ItemService {

    public Item createItem(Item item);

    public Item updateItem(int id, Item item);

    public Item getItemBasedOnId(int id);

    public List<Item> getAllItems();

    public boolean deleteItem(Item item);

}
