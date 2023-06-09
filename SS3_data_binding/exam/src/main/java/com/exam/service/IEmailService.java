package com.exam.service;

import com.exam.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> getLanguages();
    List<Integer> getSizes();

    Email update(Email email);
}
