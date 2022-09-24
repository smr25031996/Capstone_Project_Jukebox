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
    private String playListName;
    private List<Song> songList;


    // This is a constructor.


    public PlayList(String playListName) {
        this.playListName = playListName;
        songList = new ArrayList<>();
    }

    public List<Song> getSongList() {
        return songList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return Objects.equals(playListName, playList.playListName) && Objects.equals(songList, playList.songList);
    }


    @Override
    public int hashCode() {
        return Objects.hash(playListName, songList);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playListName='" + playListName + '\'' +
                ", songList=" + songList +
                '}';
    }
}
