/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import com.niit.jdp.repository.SongRepository;

import java.sql.SQLException;

import static java.lang.System.out;

public class SongListService {
    // Creating an object of SongRepository class.
    SongRepository songRepository = new SongRepository();

    // Creating an object of DatabaseService class.
    DatabaseService databaseService = new DatabaseService();

    /**
     * > This function displays all the songs in the database
     */
    public void displaySongMenu() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        var allSong = songRepository.getAll(databaseService.getDatabaseConnection());
        out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        out.println("SongId    Song Name           Artist              Album          Genre          Duration");
        out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Printing all the songs in the database.
        allSong.forEach(out::println);
        out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
