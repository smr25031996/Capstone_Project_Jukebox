/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayListRepository implements Repository {
    PlayList playList = new PlayList();

    /**
     * It creates a new table in the database with the name of the playlist
     *
     * @param connection   Connection object
     * @param playListName The name of the playlist to be created.
     */
    @Override
    public void createPlayList(Connection connection, String playListName) throws SQLException {
        String playListQuery = "CREATE TABLE `" + playListName + "` (`song_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,`song_name` VARCHAR(50),`artist_name` VARCHAR(50),`album_name` VARCHAR(50),`song_genre` VARCHAR(50),`song_duration` varchar(20));";
        try (Statement statement = connection.createStatement()) {
            statement.execute(playListQuery);
        }
    }

    /**
     * This function adds a song to a playlist
     *
     * @param connection   Connection object
     * @param playListName The name of the playlist to which the song is to be added.
     * @param songId       The id of the song to be added to the playlist.
     * @return The method returns a boolean value.
     */
    @Override
    public boolean addSongInPlayList(Connection connection, String playListName, int songId) throws SQLException {
        String addSongQuery = "INSERT INTO `" + playListName + "` (`song_id`,`song_name`,`artist_name`,`album_name`,`song_genre`,`song_duration`)SELECT * FROM `songslist` where `song_id`=? ";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(addSongQuery)) {
            preparedStatement.setInt(1, songId);

            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    /**
     * It takes a connection, an album name and a playlist name as parameters and adds all the songs from the album to the
     * playlist
     *
     * @param connection Connection object
     * @param album      The name of the album to be added to the playlist.
     * @param playList   The name of the playlist to which the album is to be added.
     * @return boolean
     */
    public boolean addAlbumToThePlayList(Connection connection, String album, String playList) throws SQLException {
        String addAlbum = "INSERT INTO `" + playList + "` (`song_id`,`song_name`,`artist_name`,`album_name`,`song_genre`,`song_duration`)SELECT * FROM `songslist` where `album_name`=? ";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(addAlbum)) {
            preparedStatement.setString(1, album);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }

        return numberOfRowsAffected > 0;
    }

    /**
     * It removes a song from a playlist
     *
     * @param connection   The connection object to the database.
     * @param playListName The name of the playlist from which the song is to be removed.
     * @param songId       The id of the song to be removed from the playlist.
     * @return The method returns a boolean value.
     */
    @Override
    public boolean removeSongFromPlayList(Connection connection, String playListName, int songId) throws SQLException {
        String removeQuery = "DELETE FROM `jukebox`.`" + playListName + "` WHERE (`song_id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeQuery)) {
            preparedStatement.setInt(1, songId);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }
}
