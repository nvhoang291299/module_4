package com.example.exam2.repository;

import com.example.exam2.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Long> {
}
