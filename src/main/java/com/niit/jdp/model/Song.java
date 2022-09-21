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
    private int songDuration;
    private String songAlbum;

    // This is a no-args constructor.
    public Song() {
    }

    public Song(int songId, String songName, String songGenre, String songArtist, int songDuration, String songAlbum) {
        this.songId = songId;
        this.songName = songName;
        this.songGenre = songGenre;
        this.songArtist = songArtist;
        this.songDuration = songDuration;
        this.songAlbum = songAlbum;
    }
// This is a parametrised constructor.


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

    public int getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(int songDuration) {
        this.songDuration = songDuration;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && songDuration == song.songDuration && Objects.equals(songName, song.songName) && Objects.equals(songGenre, song.songGenre) && Objects.equals(songArtist, song.songArtist) && Objects.equals(songAlbum, song.songAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, songGenre, songArtist, songDuration, songAlbum);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songGenre='" + songGenre + '\'' +
                ", songArtist='" + songArtist + '\'' +
                ", songDuration=" + songDuration +
                ", songAlbum='" + songAlbum + '\'' +
                '}';
    }
}
