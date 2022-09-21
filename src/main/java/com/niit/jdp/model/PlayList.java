/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayList {
    // fields for class
    private int playListId;
    private String playListName;
    private List<Song> songList;

    // This is a constructor.
    public PlayList() {
        this.songList = new ArrayList<>();
    }

    public PlayList(int playListId, String playListName) {
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
