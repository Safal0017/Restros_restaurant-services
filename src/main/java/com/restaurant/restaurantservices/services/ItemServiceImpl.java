package com.restaurant.restaurantservices.services;

import com.restaurant.restaurantservices.entities.Item;
import com.restaurant.restaurantservices.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(int id, Item item) {
        Item itemToBeUpdated = getItemBasedOnId(id);
        itemToBeUpdated.setItemName(item.getItemName());
        itemToBeUpdated.setItemPrice(item.getItemPrice());
        itemToBeUpdated.setCategory(item.getCategory());
        Item savedItem = itemRepository.save(itemToBeUpdated);
        return savedItem;
    }

    @Override
    public Item getItemBasedOnId(int id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public boolean deleteItem(Item item) {
        Item itemToBeDeleted = getItemBasedOnId(item.getItemId());
        if(itemToBeDeleted == null) {
            return false;
        }
        itemRepository.delete(itemToBeDeleted);
        return true;
    }
}
