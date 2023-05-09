package com.example.exam1.repository.impl;

import com.example.exam1.repository.ISpiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpiceRepository implements ISpiceRepository {
    private static List<String> list = new ArrayList<>();
    static {
        list.add("Letture");
        list.add("Tomato");
        list.add("Mustard");
        list.add("Sprouts");
        list.add("Cheese");

    }
    @Override
    public List<String> getAll() {
        return list;
    }
}
