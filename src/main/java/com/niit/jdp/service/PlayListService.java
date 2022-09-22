/*
 * Author Name: Shubham Rajput
 * Date: 22-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import com.niit.jdp.model.PlayList;
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
    public List<PlayList> sortAccordingToGivenType(String sortType) throws SQLException, ClassNotFoundException {
        databaseService.connect();
        List<PlayList> songList = null;
        List<Song> songList1 = songRepository.getAll(databaseService.getDatabaseConnection());
        for (int index = 0; index < songList1.size(); index++) {
            songList.add(songList1.get(index));
        }
        Comparator<PlayList> songComparator = (o1, o2) -> {
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

    /**
     * It takes a list of songs, a sort type and a playlist name as input and displays the songs in the playlist sorted
     * according to the sort type
     *
     * @param sortType     This is the type of sorting that the user wants to do.
     * @param playListName The name of the playlist that you want to display.
     */
    public void displaySortedList(String sortType, String playListName) throws SQLException, ClassNotFoundException {
        List<PlayList> sortedAccordingToGivenType = sortAccordingToGivenType(sortType);
        System.out.println("playListName = " + playListName);
        System.out.println("=========================================================================================");
        System.out.println("SongId    Song Name           Artist              Album          Genre          Duration");
        System.out.println("=========================================================================================");
        sortedAccordingToGivenType.forEach(System.out::println);
        System.out.println("=========================================================================================");
    }

}
