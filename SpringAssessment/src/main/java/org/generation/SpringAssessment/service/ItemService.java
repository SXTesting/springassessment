package org.generation.SpringAssessment.service;

//Interface as a guide on what are the methods that are available that the controller can call and perform action

//Service layer is to be developed by developer A, controller layer is to be developed by Developer B, Developer B will be accessing the interface document to know what are the method available for him/her to call.

import java.util.List;
import org.generation.SpringAssessment.repository.entity.*;

public interface ItemService {

    //will show what are methods for this Item Service
    //e.g. 1) Provides list all items from the database
    List<Item> all();

    //this method is use for both add item and edit item
    Item save(Item item);

    void delete(int itemId);

    Item findById(int itemId);
}