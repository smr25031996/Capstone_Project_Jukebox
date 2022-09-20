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
}
