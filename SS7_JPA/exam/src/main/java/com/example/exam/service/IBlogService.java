package com.example.exam.service;

import com.example.exam.model.Blog;

import java.util.List;

public interface IBlogService {
    void save(Blog blog);

    List<Blog> findAll();
}
