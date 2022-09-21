/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    // Declaring the variables.
    private int songId;
    private String songName;
    private String songGenre;
    private String songArtist;

    // This is a no-args constructor.
    public Song() {
    }

    // This is a parametrised constructor.
    public Song(int songId, String songName, String songGenre, String songArtist) {
        this.songId = songId;
        this.songName = songName;
        this.songGenre = songGenre;
        this.songArtist = songArtist;
    }

    // This is a getter and setter method.
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && Objects.equals(songName, song.songName) && Objects.equals(songGenre, song.songGenre) && Objects.equals(songArtist, song.songArtist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, songGenre, songArtist);
    }

    @Override
    public String toString() {
        return "Song{" + "songID=" + songId + ", songName='" + songName + '\'' + ", songGenre='" + songGenre + '\'' + ", songArtist='" + songArtist + '\'' + '}';
    }
}
