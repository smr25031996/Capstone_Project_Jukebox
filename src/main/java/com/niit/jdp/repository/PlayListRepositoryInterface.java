package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface PlayListRepositoryInterface {
    //if user wants to create the playlist
    //method for create  the playlist
    boolean createPlayList(Connection connection, String playListName) throws SQLException;

    boolean addSongInPlayList(Connection connection);
}
