/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.exception.ArtistNotFoundException;
import com.niit.jdp.exception.SongNotFoundException;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlayListRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;
import com.niit.jdp.service.PlayListService;
import com.niit.jdp.service.SongListService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, RuntimeException, ArtistNotFoundException, SongNotFoundException {

        out.println("******************** Wel Come to the World of Songs ********************");
        Scanner scanner = new Scanner(in);
        int choice;
        do {
            out.println("Press '1' for seeing the Song that we offered ");
            out.println("Press '2' for Sorting the song list");
            out.println("Press '3' for Listening particular song from the playlist");
            out.println("Press '4' for Creating your own playlist");
            out.println("Press '5' for Closing music program");
            out.println("Please Enter your choice");
            choice = scanner.nextInt();
            controlAccordingToUserChoice(choice);
        } while (choice != 5);
    }

    public static void controlAccordingToUserChoice(int choice) throws SQLException, ClassNotFoundException, ArtistNotFoundException, SongNotFoundException {
        Scanner scanner = new Scanner(in);
        String defaultPlaylist = "SongsList";
        String songName = "Agar Tum Saath Ho";
        SongListService songListService = new SongListService();
        SongRepository songRepository = new SongRepository();
        PlayListRepository playListRepository = new PlayListRepository();
        PlayListService playListService = new PlayListService();
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
                out.println("Please enter the basis on you want to sort the song list ");
                out.println("Sort types are -> song,artist,album,genre");
                String sortType = scanner.nextLine();
                // Sorting the song list according to the given type.
                playListService.displaySortedList(sortType, defaultPlaylist);
                break;
            case 3:
                //for listening one song
                out.println("Please Enter the Song you want to hear");
                out.println("you can choose song according : number,song ,artist ,album,genre");
                out.println("Kindly enter your choice");
                String choiceOfUser = scanner.next().toLowerCase();
                switch (choiceOfUser) {
                    case "number":
                        out.println("Please Enter the number of  Song you want to hear");
                        int numberOfSong = scanner.nextInt();
                        //if user chose to find according to number of song
                        songName = songRepository.getSongById(databaseService.getDatabaseConnection(), numberOfSong);
                        out.println("song playing = " + songName);
                        break;
                    case "song":
                        // Displaying the list of songs available in the database.
                        songListService.displaySongMenu();
                        out.println("Ajeeb Dastaan, Matargashti, Mere Sapnon, Dil Se Re, Agar Tum Saath Ho, Airanichya deva, Yeh Kya Hua, Jai Ho, Yeh Jo Mohabbat, Kabhi Neem Neem");
                        out.println("Please Enter the name of  Song you want to hear from the song list");
                        String name = scanner.nextLine();
                        // Getting the song by name.
                        songName = songRepository.getSongBySongName(databaseService.getDatabaseConnection(), name, defaultPlaylist);
                        out.println("song playing = " + songName);
                        break;
                    case "artist":
                        out.println("Please Enter the name of  artist whose song you want to hear from the song list");
                        String artist = scanner.nextLine();
                        songName = songRepository.getSongByArtists(databaseService.getDatabaseConnection(), artist, defaultPlaylist);
                        out.println("song playing = " + songName);
                        break;
                    case "genre":
                        out.println("Please Enter the name of  genre from which you want to hear song");
                        String genre = scanner.nextLine();
                        songName = songRepository.getSongByGenre(databaseService.getDatabaseConnection(), genre, defaultPlaylist);
                        out.println("song playing = " + songName);
                        break;
                    case "album":
                        out.println("Please Enter the name of  album from which you want to hear song");
                        String album = scanner.nextLine();
                        songName = songRepository.getSongByAlbum(databaseService.getDatabaseConnection(), album, defaultPlaylist);
                        out.println("song playing = " + songName);
                        break;
                    default:
                        out.println("Wrong Choice,Please Enter valid choice");
                        break;
                }
                // Playing the song.
                musicPlayer.playSong(songName);
                break;
            case 4:
                //Creating your own playlist
                out.println("Please enter the playlist name, you want create");
                String playlistName = scanner.nextLine();
                playListRepository.createPlayList(databaseService.getDatabaseConnection(), playlistName);
                //if user wants to add, remove the music to newly created playlist
                int userInput;
                do {
                    out.println("Press '1' for adding the song ");
                    out.println("Press '2' for removing the song list");
                    out.println("Press '3' for exit");
                    out.println("Please Enter your choice");
                    userInput = scanner.nextInt();
                    if (userInput == 1) {
                        out.println("Please Enter the song Number which you want add in your Playlist");
                        int songNumber = scanner.nextInt();
                        playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), playlistName, songNumber);
                        out.println(songRepository.getSongById(databaseService.getDatabaseConnection(), songNumber) + " Song is added in the " + playlistName);
                    } else if (userInput == 2) {
                        out.println("Please Enter the song Number which you want remove in your repository");
                        int songNumber = scanner.nextInt();
                        playListRepository.removeSongFromPlayList(databaseService.getDatabaseConnection(), playlistName, songNumber);
                        out.println(songRepository.getSongById(databaseService.getDatabaseConnection(), songNumber) + " Song is removed in the " + playlistName);
                    }
                } while (userInput != 3);
                // Getting all the songs in the playlist.
                List<Song> createdPlayList = playListRepository.getAllSongsInPlayList(databaseService.getDatabaseConnection(), playlistName);
                // Displaying the created playlist.
                playListService.displayCreatedPlayList(createdPlayList, playlistName);
                //now if user want play any song of created playlist then
                //for listening one song
                out.println("Please Enter the Song you want to hear");
                out.println("you can choose song according : number,song ,artist ,album,genre");
                out.println("Kindly enter your choice");
                String userChoice = scanner.next().toLowerCase();
                switch (userChoice) {
                    case "number":
                        out.println("Please Enter the number of  Song you want to hear");
                        int numberOfSong = scanner.nextInt();
                        //if user chose to find according to number of song
                        songName = songRepository.getSongById(databaseService.getDatabaseConnection(), numberOfSong);
                        out.println("song playing = " + songName);
                        break;
                    case "song":
                        // Displaying the list of songs available in the database.
                        songListService.displaySongMenu();
                        out.println("Ajeeb Dastaan, Matargashti, Mere Sapnon, Dil Se Re, Agar Tum Saath Ho, Airanichya deva, Yeh Kya Hua, Jai Ho, Yeh Jo Mohabbat, Kabhi Neem Neem");
                        out.println("Please Enter the name of  Song you want to hear from the song list");
                        String name = scanner.nextLine();
                        // Getting the song by name.
                        songName = songRepository.getSongBySongName(databaseService.getDatabaseConnection(), name, playlistName);
                        out.println("song playing = " + songName);
                        break;
                    case "artist":
                        out.println("Please Enter the name of  artist whose song you want to hear from the song list");
                        String artist = scanner.nextLine();
                        songName = songRepository.getSongByArtists(databaseService.getDatabaseConnection(), artist, playlistName);
                        out.println("song playing = " + songName);
                        break;
                    case "genre":
                        out.println("Please Enter the name of  genre from which you want to hear song");
                        String genre = scanner.nextLine();
                        songName = songRepository.getSongByGenre(databaseService.getDatabaseConnection(), genre, playlistName);
                        out.println("song playing = " + songName);
                        break;
                    case "album":
                        out.println("Please Enter the name of  album from which you want to hear song");
                        String album = scanner.nextLine();
                        songName = songRepository.getSongByAlbum(databaseService.getDatabaseConnection(), album, playlistName);
                        out.println("song playing = " + songName);
                        break;
                    default:
                        out.println("Wrong Choice,Please Enter valid choice");
                        break;
                }
                musicPlayer.playSong(songName);
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

