package com.example.ss3_data_binding.repository;

import com.example.ss3_data_binding.model.Login;
import com.example.ss3_data_binding.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
