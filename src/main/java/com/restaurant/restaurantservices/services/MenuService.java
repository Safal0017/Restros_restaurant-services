package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Item;
import com.restaurant.restaurantservices.entities.Menu;

import java.util.List;

public interface MenuService {

    public Menu createMenu(Menu menu);

    public Menu getMenuBasedOnId(int id);

    public List<Menu> getAllMenus();

    public boolean deleteMenu(Menu menu);

}
