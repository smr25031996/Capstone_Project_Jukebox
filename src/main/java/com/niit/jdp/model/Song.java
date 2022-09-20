/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

public class Song {
    // Declaring the variables.
    private int songID;
    private String songName;
    private String songGenre;
    private String songArtist;

    // This is a no-args constructor.
    public Song() {
    }

    // This is a parametrised constructor.
    public Song(int songID, String songName, String songGenre, String songArtist) {
        this.songID = songID;
        this.songName = songName;
        this.songGenre = songGenre;
        this.songArtist = songArtist;
    }

    // This is a getter and setter method.
    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
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
}
