package org.generation.SpringAssessment.controller;

import org.generation.SpringAssessment.controller.dto.ItemDto;
import org.generation.SpringAssessment.repository.entity.*;
import org.generation.SpringAssessment.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/item")
public class ItemController {

    //ItemController is dependent on ItemService to perform this save, delete, all, findItemById

    final ItemService itemService;

    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    //1) Create an API endpoint for GET HTTP Request from the client
    //CORS (Cross-origin resource sharing)
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

    //2) Create an API endpoint for GET HTTP Request from the client by Id
    @CrossOrigin
    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    //3) Create an API endpoint for DELETE HTTP Request from the client by Id
    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    //4) Create an API endpoint for POST HTTP Request from the client
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="date", required = true) String date) throws IOException {


        ItemDto itemDto = new ItemDto(title, description, date);
        itemService.save(new Item(itemDto));
    }


}
