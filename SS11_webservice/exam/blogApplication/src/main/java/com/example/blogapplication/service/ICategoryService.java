package com.example.blogapplication.service;

import com.example.blogapplication.model.Blog;
import com.example.blogapplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICategoryService{

    List<Category> findAll();
}
