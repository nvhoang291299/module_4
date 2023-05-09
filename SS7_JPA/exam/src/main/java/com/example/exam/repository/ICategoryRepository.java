package com.example.exam.repository;

import com.example.exam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Override
    List<Category> findAll();
}
