package com.playlist.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    ArrayList<Song> songs;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song s : this.songs) {
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            Song song = this.songs.get(index);
            if (song != null) {
                playList.add(song);
                return true;
            }
        }
        System.out.println("The album" + artist + "-" + name + " does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> songs) {
        Song foundSong = this.findSong(title);
        if (foundSong != null) {
            songs.add(foundSong);
            return true;
        }
        System.out.println("The album" + artist + "-" + name + " does not have a song \"" + title + "\"");
        return false;
    }
}


