package ru.gb.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "name")
    private String name;
}
