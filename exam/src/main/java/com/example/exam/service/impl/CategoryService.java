package com.example.exam.service.impl;

import com.example.exam.model.Blog;
import com.example.exam.model.Category;
import com.example.exam.repository.ICategoryRepository;
import com.example.exam.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void delete(long idDel) {
        categoryRepository.deleteById(idDel);
    }
}
