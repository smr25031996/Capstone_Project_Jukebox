/*
 * Author Name: Shubham Rajput
 * Date: 22-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import com.niit.jdp.model.Song;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class PlayListService {

    DatabaseService databaseService = new DatabaseService();

    /**
     * It takes a sort type as a parameter, gets all the songs from the database, sorts them according to the sort type and
     * returns the sorted list
     *
     * @param sortType The type of sorting you want to do.
     * @return A list of songs sorted according to the given type.
     */
    public List<Song> sortAccordingToGivenType(String sortType, List<Song> songList) throws SQLException, ClassNotFoundException {
        // Converting the sortType to lower case.
        databaseService.connect();
        Comparator<Song> songComparator = (o1, o2) -> {
            switch (sortType) {
                case "song":
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
    public void displaySortedList(String sortType, String playListName, List<Song> songs) throws SQLException, ClassNotFoundException {
        List<Song> sortedAccordingToGivenType = sortAccordingToGivenType(sortType, songs);
        out.println("playListName = " + playListName);
        out.println("=========================================================================================");
        out.println("SongId    Song Name           Artist              Album          Genre          Duration");
        out.println("=========================================================================================");
        sortedAccordingToGivenType.forEach(out::println);
        out.println("=========================================================================================");
    }

    public void displayCreatedPlayList(List<Song> newPlayListSongs, String playlistName) {
        out.println("playListName = " + playlistName);
        out.println("=========================================================================================");
        out.println("SongId    Song Name           Artist              Album          Genre          Duration");
        out.println("=========================================================================================");
        newPlayListSongs.forEach(out::println);
        out.println("=========================================================================================");

    }

}
