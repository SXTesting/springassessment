package org.generation.SpringAssessment.repository.entity;

//This is in the Modal component (MVC Design Pattern)
//Item Class object will be used to map up with the Item Table from the database

//We are using the same name for Class Object and Table Name, as well as the name naming convention for attributes

import org.generation.SpringAssessment.controller.dto.ItemDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Item {

    //We need to identify which attribute is the id (Primary Key), and how the id is generated

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //using Wrapper Class Integer (Object) instead of int (Primitive)
    //need to pass the id to a class method FindItemById()
    private String title;
    private String description;
    private String date;

    public Item() {}

    public Item(ItemDto itemDto) {
        this.title = itemDto.getTitle();
        this.description = itemDto.getDescription();
        this.date = itemDto.getDate();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate( String date )
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", date='"
                + date + '}';
    }

}
