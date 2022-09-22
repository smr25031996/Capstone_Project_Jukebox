/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

public class PlayList {
    // fields for class
    private int playListId;
    private String playListName;
    private int songId;
    private String songName;
    private String songArtist;
    private String songAlbum;
    private String songGenre;
    private String songDuration;


    // This is a constructor.


    public PlayList() {
    }

    public PlayList(int songId, String songName, String songArtist, String songAlbum, String songGenre, String songDuration) {
        this.songId = songId;
        this.songName = songName;
        this.songArtist = songArtist;
        this.songAlbum = songAlbum;
        this.songGenre = songGenre;
        this.songDuration = songDuration;
    }

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

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

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return playListId == playList.playListId && songId == playList.songId && Objects.equals(playListName, playList.playListName) && Objects.equals(songName, playList.songName) && Objects.equals(songArtist, playList.songArtist) && Objects.equals(songAlbum, playList.songAlbum) && Objects.equals(songGenre, playList.songGenre) && Objects.equals(songDuration, playList.songDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playListId, playListName, songId, songName, songArtist, songAlbum, songGenre, songDuration);
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-15s%-15s%-15s", songId, songName, songArtist, songAlbum, songGenre, songDuration);

    }
}
