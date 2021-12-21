package ru.gb.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_price")
    private double orderPrice;

    //TODO - do we need a status object?
    @Column(name = "status")
    private String status;

    @Column(name = "quantity")
    private int productQuantity;

}
