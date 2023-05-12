package com.example.exam.service;

import com.example.exam.model.Blog;
import com.example.exam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICategoryService{

    List<Category> findAll();

    void delete(long idDel);

    Optional<Category> findById(long id);

    void save(Category category);
}
