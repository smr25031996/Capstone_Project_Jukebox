/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayListRepository implements PlayListRepositoryInterface {
    //if user wants to create the playlist
    //method for create  the playlist
    @Override
    public boolean createPlayList(Connection connection, String playListName) throws SQLException {
        String playListQuery = "CREATE TABLE `" + playListName + "` (`song_id` INT NOT NULL PRIMARY KEY,`song_name` VARCHAR(50),`artist_name` VARCHAR(50),`album_name` VARCHAR(50),`song_genere` VARCHAR(50),`song_duartion` varchar(20));";
        int numberOfRowAffected = 0;
        try (Statement statement = connection.createStatement()) {
            statement.execute(playListQuery);
        }
        return numberOfRowAffected > 0;
    }

    @Override
    public boolean addSongInPlayList(Connection connection) {

        return false;
    }

}
