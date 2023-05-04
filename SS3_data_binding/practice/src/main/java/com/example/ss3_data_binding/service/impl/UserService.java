package com.example.ss3_data_binding.service.impl;

import com.example.ss3_data_binding.model.Login;
import com.example.ss3_data_binding.model.User;
import com.example.ss3_data_binding.repository.IUserRepository;
import com.example.ss3_data_binding.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    public User checkLogin(Login login) {
        return iUserRepository.checkLogin(login);
    }
}
