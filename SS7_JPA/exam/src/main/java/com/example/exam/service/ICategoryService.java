package com.example.exam.service;

import com.example.exam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryService{

    List<Category> findAll();
}
