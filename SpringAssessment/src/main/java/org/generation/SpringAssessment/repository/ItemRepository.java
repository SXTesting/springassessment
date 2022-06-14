package org.generation.SpringAssessment.repository;

//The ItemRepository created is to extend the CRUDRepository provided by Spring Data JPA Package

import org.springframework.data.repository.*;
import org.generation.SpringAssessment.repository.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    //Not only the ItemRepository inherit all the methods from the CrudRepository
    //Interface, ItemRepository and also have it's own methods

    //So now I can use the ItemRepository interface to perform basic CRUD operation
}