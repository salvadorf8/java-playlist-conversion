package com.playlist.model;

public class Song {
    private String title;
    private double duration;

    public Song(String song, double duration) {
        this.title = song;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "%-25s%.2f".formatted(title, duration);
    }
}
