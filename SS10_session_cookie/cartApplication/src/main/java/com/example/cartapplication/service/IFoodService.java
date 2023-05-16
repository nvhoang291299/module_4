package com.example.cartapplication.service;

import com.example.cartapplication.model.Food;

import java.util.List;
import java.util.Optional;

public interface IFoodService {
    List<Food> findAll();

    Optional<Food> findById(long id);
}
