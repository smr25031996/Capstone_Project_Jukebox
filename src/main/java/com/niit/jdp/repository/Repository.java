package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface Repository {

    void createPlayList(Connection connection, String playListName) throws SQLException;

    boolean addSongInPlayList(Connection connection, String playListName, int songId) throws SQLException;

    public boolean removeSongFromPlayList(Connection connection, String playListName, int songId) throws SQLException;


}
