package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Menu;
import com.restaurant.restaurantservices.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu getMenuBasedOnId(int id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public boolean deleteMenu(Menu menu) {
        Menu menuToBeDeleted = getMenuBasedOnId(menu.getMenuId());
        if(menuToBeDeleted == null) {
            return false;
        }
        menuRepository.delete(menuToBeDeleted);
        return true;
    }
}
