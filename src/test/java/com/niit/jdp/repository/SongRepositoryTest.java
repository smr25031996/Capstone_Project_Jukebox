package com.niit.jdp.repository;

import com.niit.jdp.exception.ArtistNotFoundException;
import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SongRepositoryTest {
    SongRepository songRepository;
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        songRepository = new SongRepository();
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        databaseService = null;
    }

    @Test
    void getAll() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        List<Song> actual = songRepository.getAll(databaseService.getDatabaseConnection());
        assertNotEquals(null, actual);
    }

    @Test
    void getSongById() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        String expected = "Yeh_Jo_Mohabbat";
        String actual = songRepository.getSongById(databaseService.getDatabaseConnection(), 9);
        assertEquals(expected, actual, "You Entered wrong id");
        String songName = "Dil_Se_Re";
        assertNotEquals(songName, songRepository.getSongById(databaseService.getDatabaseConnection(), 8));
    }

    @Test
    void getSongBySongName() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        String expected = "Mere_Sapnon";
        String actual = songRepository.getSongBySongName(databaseService.getDatabaseConnection(), "Agar_Tum_Saath_Ho", "songslist");
        assertNotEquals(expected, actual, "You Entered wrong id");
        String songName = "Dil_Se_Re";
        assertEquals(songName, songRepository.getSongBySongName(databaseService.getDatabaseConnection(), "Dil_Se_Re", "songslist"));
    }

    @Test
    void getSongByAlbum() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        String expected = "Mere_Sapnon";
        String actual = songRepository.getSongByAlbum(databaseService.getDatabaseConnection(), "Aradhana", "songslist");
        assertEquals(expected, actual, "You Entered wrong id");
        String songName = "Dil_Se_Re";
        assertNotEquals(songName, songRepository.getSongByAlbum(databaseService.getDatabaseConnection(), "Tamasha", "songslist"));

    }

    @Test
    void getSongByGenre() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        String expected = "Kabhi_Neem_Neem";
        String actual = songRepository.getSongByGenre(databaseService.getDatabaseConnection(), "Bollywood", "songslist");
        assertEquals(expected, actual, "You Entered wrong id");
        String songName = "Dil_Se_Re";
        assertNotEquals(songName, songRepository.getSongByGenre(databaseService.getDatabaseConnection(), "Bollywood", "songslist"));

    }

    @Test
    void getSongByArtists() throws SQLException, ClassNotFoundException, ArtistNotFoundException {
        databaseService.connect();
        String expected = "Yeh_Kya_Hua";
        String actual = songRepository.getSongByArtists(databaseService.getDatabaseConnection(), "Rajesh_Khanna", "songslist");
        assertEquals(expected, actual, "You Entered wrong id");
        String songName = "Dil_Se_Re";
        assertNotEquals(songName, songRepository.getSongByArtists(databaseService.getDatabaseConnection(), "Dil_Se", "songslist"));

    }
}