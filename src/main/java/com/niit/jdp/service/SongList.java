/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class SongList {
    // Creating an object of SongRepository class.
    SongRepository songRepository = new SongRepository();

    // Creating an object of DatabaseService class.
    DatabaseService databaseService = new DatabaseService();

    /**
     * > This function displays all the songs in the database
     */
    public void displaySongMenu() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        List<Song> allSong = songRepository.getAll(databaseService.getDatabaseConnection());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("SongId    Song Name           Artist              album          genre          duration");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Printing all the songs in the database.
        allSong.forEach(System.out::println);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public List<Song> sortAccordingToGivenType(String sortType) throws SQLException {
        List<Song> songList = songRepository.getAll(databaseService.getDatabaseConnection());
        Comparator<Song> songComparator = (o1, o2) -> {
            switch (sortType) {
                case "songName":
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.getSongName(), o2.getSongName());
                case "artist":
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.getSongArtist(), o2.getSongArtist());
                case "genre":
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.getSongGenre(), o2.getSongGenre());
                case "album":
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.getSongAlbum(), o2.getSongAlbum());
                default:
                    throw new IllegalStateException("Unexpected value: " + sortType);
            }
        };
        songList.sort(songComparator);
        return songList;
    }
}
