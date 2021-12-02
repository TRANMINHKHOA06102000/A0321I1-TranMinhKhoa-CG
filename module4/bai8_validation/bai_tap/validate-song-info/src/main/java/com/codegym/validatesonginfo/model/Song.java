package com.codegym.validatesonginfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "{errorNull}")
    @Size(max=800, message = "{errorSize}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "{errorRegex}")
    private String nameSong;
    @NotEmpty(message = "{errorNull}")
    @Size(max=1000, message = "{errorsize}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "{errorRegex}")
    private String singer;
    @NotEmpty(message = "{errorNull}")
    @Size(max=300, message = "{errorsize}")
    @Pattern(regexp = "^[a-zA-Z0-9,]*$",message = "{errorKindOfMusic}")
    private String kindOfMusic;
    
    public Song() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
    
}
