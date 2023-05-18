package com.example.blogapplication.repository;

import com.example.blogapplication.model.Blog;
import com.example.blogapplication.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Override
    List<Category> findAll();
}
