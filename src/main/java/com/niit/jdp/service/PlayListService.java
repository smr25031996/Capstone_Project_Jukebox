/*
 * Author Name: Shubham Rajput
 * Date: 22-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class PlayListService {
    SongRepository songRepository = new SongRepository();
    DatabaseService databaseService = new DatabaseService();

    /**
     * It takes a sort type as a parameter, gets all the songs from the database, sorts them according to the sort type and
     * returns the sorted list
     *
     * @param sortType The type of sorting you want to do.
     * @return A list of songs sorted according to the given type.
     */
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
