package com.example.ps04;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(String title, String singer, int year, int stars) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getSinger() {
        return singer;
    }
    public int getYear() {
        return year;
    }
    public int getStars() {
        return stars;
    }
}
