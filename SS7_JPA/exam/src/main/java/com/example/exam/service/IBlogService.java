package com.example.exam.service;

import com.example.exam.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    void save(Blog blog);

    List<Blog> findAll();

    Optional<Blog> findById(long id);

    void delete(long idDel);
}
