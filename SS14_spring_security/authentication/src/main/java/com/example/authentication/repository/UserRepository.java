package com.example.authentication.repository;

import com.example.authentication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);
}
