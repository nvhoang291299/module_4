package com.example.exam2.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class MusicDTO implements Validator {
    private long id;
    @NotEmpty
    @NotNull
    @Max(value= 800)
    @Pattern(regexp = "^[a-z A-Z]+$")
    private String song;
    @NotEmpty
    @NotNull
    @Max(value= 800)
    @Pattern(regexp ="^[a-z A-Z]+$")
    private String artist;
    @NotEmpty
    @NotNull
    @Pattern(regexp ="^[a-z A-Z]+$")
    private String category;

    public MusicDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
