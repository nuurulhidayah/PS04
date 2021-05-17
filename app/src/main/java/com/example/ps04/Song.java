package com.example.ps04;

public class Song {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(int id, String title, String singer, int year, int stars) {
        this.id = id;
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
