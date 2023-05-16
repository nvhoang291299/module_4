package com.example.cartapplication.service.impl;

import com.example.cartapplication.model.Food;
import com.example.cartapplication.repository.IFoodRepository;
import com.example.cartapplication.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepository foodRepository;
    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> findById(long id) {
        return foodRepository.findById(id);
    }
}
