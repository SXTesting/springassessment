package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.ItemRepository;
import org.generation.SpringAssessment.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ItemServiceMySQL implements ItemService {

    /*

        Dependency Injection
        -transferring the task of creating the object of someone else

        Normally how we create an instance object of another class
        ItemSeriveMySQL depends on the CrudRepository Class to perform CRUD operations

        //We are creating the instance object inside the ItemServiceMySQL Class
        ItemServiceMySQL myService = new CrudRepository(); //Cannot

        //ItemServiceMySQL is dependent CrudRepository

        //1) Adhere to the abstraction (hiding details) principle, where we only have the access to the interface of the Class Object. We have no direct access to the Class object itself

        //2) DI - IDC: The creating of the instance object is created by another object instead of in the ItemServiceMySQL Class

     */

    //The dependency instance object will be injected through the constructor

    private final ItemRepository itemRepository;
    public ItemServiceMySQL(@Autowired ItemRepository itemRepository)
    {
        //Injecting an instance object of the CrudRepository object
        //We are able to make use of this.itemRepository to access the properties and methods from the CrudRepository object
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        //access the database with the connection and perform Insert query
        return itemRepository.save(item); //CrudRepository object
    }

    @Override
    public void delete(int itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public List<Item> all() {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result :: add);
        return result;
    }

    @Override
    public Item findById(int itemId) {
        //update product info and delete a product
        //item is an object
        Optional<Item> item = itemRepository.findById(itemId); //Cannot be a null
        Item itemResponse = item.get();
        return itemResponse;
    }
}