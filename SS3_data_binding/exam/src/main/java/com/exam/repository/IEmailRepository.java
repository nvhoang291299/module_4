package com.exam.repository;

import com.exam.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> getLanguages();

    List<Integer> getSizes();

    Email update(Email email);
}
