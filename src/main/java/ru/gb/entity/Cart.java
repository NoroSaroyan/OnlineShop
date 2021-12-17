package ru.gb.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Cart {
    @Id
    @GeneratedValue
    protected Long id;

    protected Long productCount;

    @ManyToOne
    protected Product product;
}