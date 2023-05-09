package com.example.ss3_data_binding.service;

import com.example.ss3_data_binding.model.Login;
import com.example.ss3_data_binding.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
