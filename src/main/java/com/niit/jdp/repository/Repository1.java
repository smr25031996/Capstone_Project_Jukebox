package com.niit.jdp.repository;

import com.niit.jdp.exception.ArtistNotFoundException;
import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository1 {
    List<Song> getAll(Connection connection) throws SQLException;

    String getSongById(Connection connection, int songId) throws SQLException;

    String getSongBySongName(Connection connection, String songName, String playlist) throws SQLException;

    String getSongByAlbum(Connection connection, String album, String playlist) throws SQLException;

    String getSongByGenre(Connection connection, String genre, String playlist) throws SQLException;

    String getSongByArtists(Connection connection, String artist, String playlist) throws ArtistNotFoundException;

    boolean isSongInPlaylist(Connection connection, String songInPlaylist, String playlist) throws ArtistNotFoundException;
}
