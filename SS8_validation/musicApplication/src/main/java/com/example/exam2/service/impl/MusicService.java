package com.example.exam2.service.impl;

import com.example.exam2.model.Music;
import com.example.exam2.repository.IMusicRepository;
import com.example.exam2.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(long id) {
        return musicRepository.findById(id).get();
    }
}
