/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.exception.ArtistNotFoundException;
import com.niit.jdp.repository.PlayListRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;
import com.niit.jdp.service.PlayListService;
import com.niit.jdp.service.SongListService;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, RuntimeException, ArtistNotFoundException {

        out.println("********************Wel Come to the Song World********************");
        Scanner scanner = new Scanner(in);
        int choice;
        do {
            out.println("Press '1' Seeing the Song that we offered ");
            out.println("Press '2' for Sorting the song list");
            out.println("Press '3' for Listening particular song from the playlist");
            out.println("Press '4' for Creating your own playlist");
            out.println("Press '5' for Closing music program");
            out.println("Please Enter your choice");
            choice = scanner.nextInt();
            controlAccordingToUserChoice(choice);
        } while (choice != 5);


        // String music = "39";
//        try {
//            songListService.displaySongMenu();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        PlayListRepository playListRepository = new PlayListRepository();
//        DatabaseService databaseService = new DatabaseService();
//        databaseService.connect();
//        playListRepository.createPlayList(databaseService.getDatabaseConnection(), music);
//        System.out.println("isPlaylistCreated ");
//        boolean isSongAdded = playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), music, 4);
//        System.out.println("isSongAdded = " + isSongAdded);
//        boolean isSong2added = playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), music, 5);
//        playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), music, 10);
//        System.out.println("isSong2added = " + isSong2added);
//        PlayListService playListService = new PlayListService();
//
//        boolean isSongRemoved = playListRepository.removeSongFromPlayList(databaseService.getDatabaseConnection(), music, 4);
//        System.out.println("isSongRemoved = " + isSongRemoved);
//        SongRepository songRepository = new SongRepository();
//        playListService.displaySortedList("artist", music);
//
//        String songById1 = songRepository.getSongById(databaseService.getDatabaseConnection(), 5);
//        System.out.println("songById1 = " + songById1);
//        List<PlayList> allSongsInPlayList = playListRepository.getAllSongsInPlayList(databaseService.getDatabaseConnection(), music);
//        allSongsInPlayList.stream().forEach(System.out::println);

        //    MusicPlayerService musicPlayerService = new MusicPlayerService();
        //   musicPlayerService.playSongPlaylist(songById1);
    }

    public static void controlAccordingToUserChoice(int choice) throws SQLException, ClassNotFoundException, ArtistNotFoundException {
        Scanner scanner = new Scanner(in);

        String defaultPlaylist = "SongsList";
        String songName = "Agar Tum Saath Ho";
        SongListService songListService = new SongListService();
        SongRepository songRepository = new SongRepository();
        PlayListRepository playListRepository = new PlayListRepository();
        MusicPlayerService musicPlayer = new MusicPlayerService();
        DatabaseService databaseService = new DatabaseService();
        databaseService.connect();
        switch (choice) {
            case 1:
                //for displaying available list
                // Creating an object of SongListService class.
                out.println("playlistName = " + defaultPlaylist);
                // Displaying the list of songs available in the database.
                songListService.displaySongMenu();
                break;
            case 2:
                //for sorting available list
                // Creating an object of PlayListService class.
                PlayListService playListService = new PlayListService();
                out.println("Please enter the basis on you want to sort the song list ");
                out.println("Sort types are -> song,artist,album,genre");
                String sortType = scanner.nextLine();
                // Sorting the song list according to the given type.
                playListService.displaySortedList(sortType, defaultPlaylist);
                break;
            case 3:
                out.println("Please Enter the Song you want to hear");
                out.println("you can choose song according : song number,song ,artist ,album,genre");
                out.println("Kindly enter your choice");
                String choiceOfUser = scanner.next().toLowerCase();
                switch (choiceOfUser) {
                    case "number":
                        out.println("Please Enter the number of  Song you want to hear");
                        int numberOfSong = scanner.nextInt();
                        //if user chose to find according to number of song
                        songName = songRepository.getSongById(databaseService.getDatabaseConnection(), numberOfSong);
                        break;
                    case "song":
                        // Displaying the list of songs available in the database.
                        songListService.displaySongMenu();
                        out.println("Please Enter the name of  Song you want to hear from the song list");
                        String name = scanner.nextLine();
                        // Getting the song by name.
                        songName = songRepository.getSongBySongName(databaseService.getDatabaseConnection(), name);
                        break;
                    case "artist":
                        out.println("Please Enter the name of  artist whose song you want to hear from the song list");
                        String artist = scanner.nextLine();
                        songName = songRepository.getSongByArtists(databaseService.getDatabaseConnection(), artist);
                        break;
                    case "genre":
                        out.println("Please Enter the name of  genre from which you want to hear song");
                        String genre = scanner.nextLine();
                        songName = songRepository.getSongByGenre(databaseService.getDatabaseConnection(), genre);
                        break;
                    case "album":
                        out.println("Please Enter the name of  album from which you want to hear song");
                        String album = scanner.nextLine();
                        songName = songRepository.getSongByAlbum(databaseService.getDatabaseConnection(), album);
                        break;
                    default:
                        out.println("Wrong Choice,Please Enter valid choice");
                        break;
                }
                // Playing the song.
                musicPlayer.playSongPlaylist(songName);
                break;
            case 4:
                //Creating your own playlist
                out.println("Please enter the playlist name, you want create");
                String playlistName = scanner.nextLine();
                playListRepository.createPlayList(databaseService.getDatabaseConnection(), playlistName);

                break;
            case 5:
                out.println("Thanks For using World of Songs");
                break;
            default:
                out.println("Wrong Choice,Please Enter valid choice");
                break;
        }
    }
}
