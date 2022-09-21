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

    // Creating an object of DatabaseService class.
    DatabaseService databaseService = new DatabaseService();

    Song song = new Song();

    /**
     * > This function displays all the songs in the database
     */
    public void displaySongMenu() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        List<Song> allSong = songRepository.getAllSong(databaseService.getDatabaseConnection());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("SongId    Song Name           Artist              album          genre          duration");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Printing all the songs in the database.
        allSong.forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


    }
}
