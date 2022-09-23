/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.exception.SongNotFoundException;
import com.niit.jdp.model.PlayList;
import com.niit.jdp.repository.PlayListRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;
import com.niit.jdp.service.PlayListService;
import com.niit.jdp.service.SongListService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, RuntimeException, SongNotFoundException {
        String music = "13";
        SongListService songListService = new SongListService();
        try {
            songListService.displaySongMenu();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        PlayListRepository playListRepository = new PlayListRepository();
        DatabaseService databaseService = new DatabaseService();
        databaseService.connect();
        playListRepository.createPlayList(databaseService.getDatabaseConnection(), music);
        System.out.println("isPlaylistCreated ");
        boolean isSongAdded = playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), music, 4);
        System.out.println("isSongAdded = " + isSongAdded);
        boolean isSong2added = playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), music, 5);
        playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), music, 10);
        System.out.println("isSong2added = " + isSong2added);
        PlayListService playListService = new PlayListService();

        boolean isSongRemoved = playListRepository.removeSongFromPlayList(databaseService.getDatabaseConnection(), music, 4);
        System.out.println("isSongRemoved = " + isSongRemoved);
        SongRepository songRepository = new SongRepository();
        playListService.displaySortedList("artist", music);

        String songById1 = songRepository.getSongById(databaseService.getDatabaseConnection(), 5);
        System.out.println("songById1 = " + songById1);
        List<PlayList> allSongsInPlayList = playListRepository.getAllSongsInPlayList(databaseService.getDatabaseConnection(), music);
        allSongsInPlayList.stream().forEach(System.out::println);

        MusicPlayerService musicPlayerService = new MusicPlayerService();
        musicPlayerService.playSongPlaylist(songById1);
    }
}
