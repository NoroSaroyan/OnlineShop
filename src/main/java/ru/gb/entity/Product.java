package ru.gb.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "title")
    private String name;

    @Column(name = "price")
    private double price;
}

