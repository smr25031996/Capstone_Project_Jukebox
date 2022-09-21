/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.util.List;

public class SongRepository implements SongRepositoryInterface {
    //get all the song list
    @Override
    public List<Song> getAllSong(Connection connection) {
        return null;
    }
}
