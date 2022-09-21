/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;

import java.sql.SQLException;
import java.util.List;

public class SongList {
    // Creating an object of SongRepository class.
    SongRepository songRepository = new SongRepository();
    DatabaseService databaseService = new DatabaseService();

    // Creating an object of DatabaseService class.
    public void displaySongMenu() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        List<Song> allSong = songRepository.getAllSong(databaseService.getDatabaseConnection());
        System.out.println(allSong);


    }
}
