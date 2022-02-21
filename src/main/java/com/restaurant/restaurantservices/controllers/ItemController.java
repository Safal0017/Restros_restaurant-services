package com.restaurant.restaurantservices.controllers;


import com.restaurant.restaurantservices.dtos.ItemDTO;
import com.restaurant.restaurantservices.entities.Item;
import com.restaurant.restaurantservices.services.ItemService;
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
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ModelMapper modelmapper;

    /**
     * CRUD Operations
     * Create - POST
     * Get item based on it's id - GET
     * Update - PUT
     * Delete - DELETE
     */

    /**
     * GET Request
     * get all items
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/items
     */

    @GetMapping(value = "/items")
    public ResponseEntity getAllItems() {
        List<Item> itemList = itemService.getAllItems();
        List<ItemDTO> itemDTOList = new ArrayList<>();
        itemList.forEach(item -> itemDTOList.add(modelmapper.map(item, ItemDTO.class)));

        return new ResponseEntity(itemDTOList, HttpStatus.OK);
    }

    /**
     * GET Request
     * get single item based on id
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/items/id
     * Example: http://localhost:8080/restaurant_app/v1/items/1
     */

    @GetMapping(value = "/items/{id}")
    public ResponseEntity getItemBasedOnId(@PathVariable(name = "id") int id) {
        Item item = itemService.getItemBasedOnId(id);
        ItemDTO itemDTO = modelmapper.map(item, ItemDTO.class);

        return new ResponseEntity(itemDTO, HttpStatus.OK);
    }

    /**
     * POST Request
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/items
     * {
     *         "itemName": "Panner Kadai",
     *         "itemPrice": 180,
     *         "category": {"categoryId": 1}
     *     }
     */

    @PostMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItem(@RequestBody ItemDTO itemDTO) {
        Item newItem = modelmapper.map(itemDTO, Item.class);
        Item savedItem = itemService.createItem(newItem);
        ItemDTO savedItemDTO = modelmapper.map(savedItem, ItemDTO.class);

        return new ResponseEntity(savedItemDTO, HttpStatus.CREATED);
    }

    /**
     * PUT Request
     * ENDPOINT: http://localhost:8080/restaurant_app/v1/items/id
     * Example: http://localhost:8080/restaurant_app/v1/items/1
     */

    @PutMapping(value = "/items/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateItem(@PathVariable(name = "id") int id,@RequestBody ItemDTO itemDTO) {
        Item itemToBeUpdated = modelmapper.map(itemDTO, Item.class);
        Item updatedItem = itemService.updateItem(id, itemToBeUpdated);
        ItemDTO updatedItemDTO = modelmapper.map(updatedItem, ItemDTO.class);

        return new ResponseEntity(updatedItemDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity deleteItem(@PathVariable(name = "id") int id) {
        Item itemToBeDeleted = itemService.getItemBasedOnId(id);
        Boolean result = itemService.deleteItem(itemToBeDeleted);
        String output;
        if(result == true) {
            output = "The item with id "+id+" deleted successfully";
        } else {
            output = "Failed to delete the item with id "+id;
        }

        return new ResponseEntity(output, HttpStatus.OK);
    }

}
