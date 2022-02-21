package com.restaurant.restaurantservices.controllers;

import com.restaurant.restaurantservices.dtos.ItemDTO;
import com.restaurant.restaurantservices.dtos.MenuDTO;
import com.restaurant.restaurantservices.entities.Item;
import com.restaurant.restaurantservices.entities.Menu;
import com.restaurant.restaurantservices.services.MenuService;
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
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ModelMapper modelmapper;

    /**
     * CRUD Operations
     * Create - POST
     * Get menu based on it's id - GET
     * Update - PUT
     * Delete - DELETE
     */

    /**
     * GET Request
     * get all menus
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/menus
     */

    @GetMapping(value = "/menus")
    public ResponseEntity getAllMenus() {
        List<Menu> menuList = menuService.getAllMenus();
        List<MenuDTO> menuDTOList = new ArrayList<>();
        menuList.forEach(menu -> menuDTOList.add(modelmapper.map(menu, MenuDTO.class)));

        return new ResponseEntity(menuDTOList, HttpStatus.OK);
    }

    /**
     * GET Request
     * get single menu based on id
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/menus/id
     * Example: http://localhost:8080/restaurant_app/v1/menus/1
     */

    @GetMapping(value = "/menus/{id}")
    public ResponseEntity getMenuBasedOnId(@PathVariable(name = "id") int id) {
        Menu menu = menuService.getMenuBasedOnId(id);
        MenuDTO menuDTO = modelmapper.map(menu, MenuDTO.class);

        return new ResponseEntity(menuDTO, HttpStatus.OK);
    }

    /**
     * GET Request
     * get list of items based on restaurant id
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/menus/hotel_id/id
     * Example: http://localhost:8080/restaurant_app/v1/menus/hotel_id/1
     */

    @GetMapping(value = "/menus/hotel_id/{id}")
    public ResponseEntity getItemsBasedOnRestaurantId(@PathVariable(name = "id") int id) {
        List<Menu> menuList = menuService.getAllMenus();
        List<Item> itemList = new ArrayList<>();
        menuList.forEach(menu -> {
            if(menu.getRestaurant().getRestaurantId() == id) {
                itemList.add(menu.getItem());
            }
        });
        List<ItemDTO> itemDTOList = new ArrayList<>();
        itemList.forEach(item -> itemDTOList.add(modelmapper.map(item, ItemDTO.class)));

        return new ResponseEntity(itemDTOList, HttpStatus.OK);
    }



    /**
     * POST Request
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/menus
     * {
     * 	"restaurant": {"restaurantId":1},
     * 	"item":{"itemId":1},
     * }
     */

    @PostMapping(value = "/menus", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMenu(@RequestBody MenuDTO menuDTO) {
        Menu newMenu = modelmapper.map(menuDTO, Menu.class);
        Menu savedMenu = menuService.createMenu(newMenu);
        MenuDTO savedMenuDTO = modelmapper.map(savedMenu, MenuDTO.class);

        return new ResponseEntity(savedMenuDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/menus/{id}")
    public ResponseEntity deleteMenu(@PathVariable(name = "id") int id) {
        Menu menuToBeDeleted = menuService.getMenuBasedOnId(id);
        Boolean result = menuService.deleteMenu(menuToBeDeleted);
        String output;
        if(result == true) {
            output = "The menu with id "+id+" deleted successfully";
        } else {
            output = "Failed to delete the menu with id "+id;
        }

        return new ResponseEntity(output, HttpStatus.OK);
    }

}
