package com.playlist.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    SongList songs;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song foundSong = songs.findSong(trackNumber);
        if(foundSong != null){
            playList.add(foundSong);
            return true;
        }
        System.out.println("The album" + artist + "-" + name + " does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song foundSong = songs.findSong(title);
        if (foundSong != null) {
            playList.add(foundSong);
            return true;
        }
        System.out.println("The album" + artist + "-" + name + " does not have a song \"" + title + "\"");
        return false;
    }

    /**
     * static inner class
     */
    private static class SongList extends ArrayList<Song> {

        private SongList() {
            super();
        }

        @Override
        public boolean add(Song song) {
            if (this.contains(song)) {
                return false;
            }
            super.add(song);
            return true;
        }

        private Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if ((index >= 0) && (index <= this.size())) {
                return this.get(index);
            }
            return null;
        }

        private Song findSong(String title) {
            for (Song s : this) {
                if (s.getTitle().equals(title)) {
                    return s;
                }
            }
            return null;
        }
    }
}


