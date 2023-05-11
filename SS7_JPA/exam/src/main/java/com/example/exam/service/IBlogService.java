package com.example.exam.service;

import com.example.exam.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    void save(Blog blog);

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(long id);

    void delete(long idDel);

    List<Blog> findByNameBlogContaining(String name);

    List<Blog> findByBlogWithSorting(String postDate);

}
