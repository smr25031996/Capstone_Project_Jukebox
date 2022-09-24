/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.exception.ArtistNotFoundException;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    // A variable that is used to store the name of the column `song_name` in the database.
    String song = "song_name";

    /**
     * This method is used to get all the songs from the database
     *
     * @param connection This is the connection object that is used to connect to the database.
     * @return A list of songs.
     */
    public List<Song> getAll(Connection connection) throws SQLException {

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
                Song songRecord = new Song(id, name, artist, album, genre, duration);

                // Adding the song object to the list of songs.
                songs.add(songRecord);
            }
        }
        return songs;
    }

    /**
     * This function takes a connection and a song id, and returns the name of the song with that id.
     *
     * @param connection The connection to the database.
     * @param songId     The id of the song you want to get the name of.
     * @return The name of the song.
     */
    public String getSongById(Connection connection, int songId) throws SQLException {

        String songQuery = "select `song_name` from `songslist` where(`song_id`=?);";
        //  create a statement object
        String songName = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(songQuery)) {

            //  set the values of the query parameters
            preparedStatement.setInt(1, songId);

            //  execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())

                // Getting the value of the column `song_name` from the result set.
                songName = resultSet.getString(song);
        }
        return songName;
    }

    /**
     * It takes a connection object and a song name as parameters and returns the song name if it exists in the database
     *
     * @param connection The connection object that is used to connect to the database.
     * @param songName   The name of the song that we want to search for.
     * @return The song name is being returned.
     */
    public String getSongBySongName(Connection connection, String songName, String playlist) throws SQLException {
        // Converting the song name to lower case.

        String songQuery = "select `song_name` from `" + playlist + "` where(`song_name`=?);";
        //  create a statement object
        String searchedSongName = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(songQuery)) {

            //  set the values of the query parameters
            preparedStatement.setString(1, songName);

            //  execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())

                // Getting the value of the column `song_name` from the result set.
                searchedSongName = resultSet.getString(song);
        }
        return searchedSongName;
    }

    /**
     * It takes a connection object and a song name as input and returns the name of the album to which the song belongs
     *
     * @param connection The connection object that is used to connect to the database.
     * @param album      The name of the album.
     * @return The song name is being returned.
     */
    public String getSongByAlbum(Connection connection, String album, String playlist) throws SQLException {
        String songQuery = "select `song_name` from `" + playlist + "` where(`song_name`=?);";
        //  create a statement object
        String searchedSongName = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(songQuery)) {

            //  set the values of the query parameters
            preparedStatement.setString(1, album);

            //  execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())

                // Getting the value of the column `song_name` from the result set.
                searchedSongName = resultSet.getString(song);
        }
        return searchedSongName;
    }

    /**
     * It takes a connection object and a genre as parameters and returns the name of the song that belongs to the genre
     *
     * @param connection The connection object that is used to connect to the database.
     * @param genre      The genre of the song.
     * @return The song name is being returned.
     */
    public String getSongByGenre(Connection connection, String genre, String playlist) throws SQLException {
        String songQuery = "select `song_name` from `" + playlist + "` where(`song_genre`=?);";
        //  create a statement object
        String searchedSongName = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(songQuery)) {

            //  set the values of the query parameters
            preparedStatement.setString(1, genre);

            //  execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())

                // Getting the value of the column `song_name` from the result set.
                searchedSongName = resultSet.getString(song);
        }
        return searchedSongName;
    }

    /**
     * It takes a connection object and an artist name as input and returns the song name of the artist
     *
     * @param connection The connection object that is used to connect to the database.
     * @param artist     The name of the artist whose song you want to search for.
     * @return The song name is being returned.
     */
    public String getSongByArtists(Connection connection, String artist, String playlist) throws ArtistNotFoundException {
        String songQuery = "select `song_name` from `" + playlist + "` where(`artist_name`=?);";
        //  create a statement object
        String searchedSongName = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(songQuery)) {

            //  set the values of the query parameters
            preparedStatement.setString(1, artist);

            //  execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())

                // Getting the value of the column `song_name` from the result set.
                searchedSongName = resultSet.getString(song);
        } catch (SQLException e) {
            throw new ArtistNotFoundException("Artist is not Found");
        }
        return searchedSongName;
    }


}

