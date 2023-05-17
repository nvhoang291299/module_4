package com.example.blogapplication.service;

import com.example.blogapplication.model.Blog;
import com.example.blogapplication.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(long id);

    List<Blog> findByCategory(String category);

    Blog save(Blog blog);

    void deleteById(long id);
}
