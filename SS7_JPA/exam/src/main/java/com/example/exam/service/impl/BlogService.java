package com.example.exam.service.impl;

import com.example.exam.model.Blog;
import com.example.exam.repository.IBlogRepository;
import com.example.exam.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(long idDel) {
        blogRepository.deleteById(idDel);
    }
}
