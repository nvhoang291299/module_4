package com.example.authentication.repository;

import com.example.authentication.model.Users;
import com.example.authentication.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(Users users);
}