package com.example.cartapplication.model;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id
}
