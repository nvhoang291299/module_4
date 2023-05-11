package com.example.exam2.service;

import com.example.exam2.model.Music;

import java.util.List;

public interface IMusicService {
    void save(Music music);

    List<Music> findAll();

    Music findById(long id);
}
