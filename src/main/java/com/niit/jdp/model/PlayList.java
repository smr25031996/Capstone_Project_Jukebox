/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlayList playList = (PlayList) o;
        return playListId == playList.playListId && Objects.equals(playListName, playList.playListName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playListId, playListName);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playListId=" + playListId +
                ", playListName='" + playListName + '\'' +
                '}';
    }
}
