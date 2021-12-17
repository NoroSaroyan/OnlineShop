package ru.gb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "products")
    @Column(name = "category_id")
    private List<Category> categories;

    @Column(name = "title")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name= "description")
    private String description;

    //TODO distinct SQL(READ)

}

