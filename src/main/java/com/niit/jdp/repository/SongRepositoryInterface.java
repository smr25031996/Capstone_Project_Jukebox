package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.util.List;

public interface SongRepositoryInterface {
    //get all the song list
    List<Song> getAllSong(Connection connection);
}
