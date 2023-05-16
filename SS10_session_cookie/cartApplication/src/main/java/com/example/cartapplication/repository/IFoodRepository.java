package com.example.cartapplication.repository;

import com.example.cartapplication.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepository extends JpaRepository<Food, Long> {
}
