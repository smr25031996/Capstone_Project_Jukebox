/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements SongRepositoryInterface {

    /**
     * This method is used to get all the songs from the database
     *
     * @param connection This is the connection object that is used to connect to the database.
     * @return A list of songs.
     */
    @Override
    // This method is used to get all the songs from the database.
    public List<Song> getAllSong(Connection connection) throws SQLException {
        // Creating a new list of songs.
        List<Song> songs = new ArrayList<>();

        // 1. create a SQL query to retrieve all the rows from the student table
        String getAllSongs = "SELECT * FROM jukebox.songslist;";

        // 2. use the connection object to execute the query
        try (Statement readSongRecords = connection.createStatement()) {

            // Executing the query and storing the result in the `songList` object.
            ResultSet songList = readSongRecords.executeQuery(getAllSongs);

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
                Song song = new Song(id, name, artist, album, genre, duration);

                // Adding the song object to the list of songs.
                songs.add(song);
            }
        }
        return songs;
    }
}
