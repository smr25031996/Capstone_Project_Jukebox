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
    private String songArtist;
    private String songAlbum;
    private String songGenre;
    private String songDuration;

    // This is a no-args constructor.
    public Song() {
    }

// This is a parametrised constructor.
    public Song(int songId, String songName, String songArtist, String songAlbum, String songGenre, String songDuration) {
        this.songId = songId;
        this.songName = songName;
        this.songArtist = songArtist;
        this.songAlbum = songAlbum;
        this.songGenre = songGenre;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && Objects.equals(songDuration, song.songDuration) && Objects.equals(songName, song.songName) && Objects.equals(songGenre, song.songGenre) && Objects.equals(songArtist, song.songArtist) && Objects.equals(songAlbum, song.songAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, songGenre, songArtist, songDuration, songAlbum);
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-15s%-15s%-15s", songId, songName, songArtist, songAlbum, songGenre, songDuration);

    }
}
