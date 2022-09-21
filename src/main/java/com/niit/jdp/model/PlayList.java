/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

public class PlayList extends Song {
    // fields for class
    private int playListId;
    private String playListName;

    // This is a constructor.
    public PlayList() {
    }

    public PlayList(int songId, String songName, String songGenre, String songArtist, int songDuration, String songAlbum, int playListId, String playListName) {
        super(songId, songName, songGenre, songArtist, songDuration, songAlbum);
        this.playListId = playListId;
        this.playListName = playListName;
    }
}
