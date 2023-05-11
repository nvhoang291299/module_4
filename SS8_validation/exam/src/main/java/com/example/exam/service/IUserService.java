package com.example.exam.service;

import com.example.exam.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    List<User> findAll();
}
