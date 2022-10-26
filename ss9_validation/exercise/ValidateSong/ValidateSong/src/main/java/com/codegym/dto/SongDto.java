package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Id;

public class SongDto implements Validator {

    private int id;
    private String name;
    private String performanceArtist;
    private String musicType;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformanceArtist() {
        return performanceArtist;
    }

    public void setPerformanceArtist(String performanceArtist) {
        this.performanceArtist = performanceArtist;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String regex = "^[\\w\\s]+$";

        SongDto songDto = (SongDto) target;
        String name = songDto.getName();
        String musicType = songDto.getMusicType();
        String performanceArtist = songDto.getPerformanceArtist();

        if("".equals(name) ) {
            errors.rejectValue("name", "", "Song name not is empty");
        } else if( name.length() > 800 || !name.matches(regex)){
            errors.rejectValue("name", "", "@+-*/..., length > 800");
        }

        if("".equals(musicType) || musicType.length() > 300 || !musicType.matches(regex)) {
            errors.rejectValue("musicType", "", "Music type not is empty, @+-*/..., length > 300");
        }

        if("".equals(performanceArtist) || performanceArtist.length() > 1000) {
            errors.rejectValue("performanceArtist", "", "Performance artist not is empty, @+-*/..., length > 1000");
        }
    }
}
