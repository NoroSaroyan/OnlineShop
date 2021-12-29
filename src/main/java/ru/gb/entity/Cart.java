package ru.gb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
//@Table(name = "carts")
//do we need a cart table? i dont think so
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Cart {
    @Id
    @GeneratedValue
    protected Long id;

    protected Long productCount;

    @ManyToOne(targetEntity = Product.class)
    protected Product product;
}