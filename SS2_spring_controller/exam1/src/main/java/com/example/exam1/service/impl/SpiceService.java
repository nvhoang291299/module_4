package com.example.exam1.service.impl;

import com.example.exam1.repository.ISpiceRepository;
import com.example.exam1.service.ISpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
public class SpiceService implements ISpiceService {
    @Autowired
    private ISpiceRepository iSpiceRepository;
    @Override
    public List<String> getAll() {
        return iSpiceRepository.getAll();
    }

}
