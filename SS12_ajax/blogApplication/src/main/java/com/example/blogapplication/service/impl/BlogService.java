package com.example.blogapplication.service.impl;

import com.example.blogapplication.model.Blog;
import com.example.blogapplication.model.Category;
import com.example.blogapplication.repository.IBlogRepository;
import com.example.blogapplication.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findByCategory(String category) {
        return blogRepository.findBlogsByCategory(category);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByWord(String word) {
        return blogRepository.findByName(word);
    }

}
