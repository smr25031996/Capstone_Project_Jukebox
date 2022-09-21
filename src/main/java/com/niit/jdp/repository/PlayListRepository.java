/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayListRepository implements PlayListRepositoryInterface {

    /**
     * It creates a new table in the database with the name of the playlist
     *
     * @param connection   Connection object
     * @param playListName The name of the playlist to be created.
     * @return The number of rows affected by the query.
     */
    @Override
    public boolean createPlayList(Connection connection, String playListName) throws SQLException {
        String playListQuery = "CREATE TABLE `" + playListName + "` (`song_id` INT NOT NULL PRIMARY KEY,`song_name` VARCHAR(50),`artist_name` VARCHAR(50),`album_name` VARCHAR(50),`song_genre` VARCHAR(50),`song_duration` varchar(20));";
        boolean isQueryExecuted;
        try (Statement statement = connection.createStatement()) {
            isQueryExecuted = statement.execute(playListQuery);
        }
        return isQueryExecuted;
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
        Song song = new Song();
        String addSongQuery = "INSERT INTO `" + playListName + "` (`song_id`,`song_name`,`artist_name`,`album_name`,`song_genre`,`song_duration`)SELECT * FROM `songslist` where `song_id`=? ";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(addSongQuery)) {
            preparedStatement.setInt(1, songId);

            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }
}
