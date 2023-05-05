package com.exam.service.impl;

import com.exam.model.Email;
import com.exam.repository.IEmailRepository;
import com.exam.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> getLanguages() {
        return iEmailRepository.getLanguages();
    }

    @Override
    public List<Integer> getSizes() {
        return iEmailRepository.getSizes();
    }

    @Override
    public Email update(Email email) {
       return  iEmailRepository.update(email);
    }
}
