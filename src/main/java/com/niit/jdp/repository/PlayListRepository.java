/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayListRepository implements Repository {

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

    public List<PlayList> getAllSongsInPlayList(Connection connection, String playlistName) {
        List<PlayList> CreatedPlayList = new ArrayList<>();
        String getAllQuery = "SELECT * FROM `jukebox`.`" + playlistName + "`;";
        try (Statement readSongRecords = connection.createStatement()) {

            // Executing the query and storing the result in the `songList` object.
            ResultSet songList = readSongRecords.executeQuery(getAllQuery);

            //iterate over the result set and storing them into  the variables
            while (songList.next()) {

                // This is iterating over the result set and storing them into  the variables
                int id = songList.getInt(1);
                String name = songList.getString(2);
                String artist = songList.getString(3);
                String album = songList.getString(4);
                String genre = songList.getString(5);
                String duration = songList.getString(6);

                //iterating over the result set crating song object fpr each row
                PlayList songRecord = new Song(id, name, artist, album, genre, duration);

                // Adding the song object to the list of songs.
                CreatedPlayList.add(songRecord);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return CreatedPlayList;
    }

}
