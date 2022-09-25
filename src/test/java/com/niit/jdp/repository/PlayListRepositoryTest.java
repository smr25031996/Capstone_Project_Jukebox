package com.niit.jdp.repository;

import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayListRepositoryTest {
    PlayListRepository playListRepository;
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        playListRepository = new PlayListRepository();
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        playListRepository = null;
    }


    @Test
    void addSongInPlayList() throws SQLException, ClassNotFoundException {
        //given wrong song number expecting return false
        int songId = 15;
        databaseService.connect();
        boolean expected = false;
        boolean actual = playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), "songslist", 15);
        assertEquals(expected, actual);
    }

    @Test
    void removeSongFromPlayList() throws SQLException, ClassNotFoundException {
        //given wrong song number expecting return false
        int songId = 15;
        databaseService.connect();
        boolean expected = false;
        boolean actual = playListRepository.addSongInPlayList(databaseService.getDatabaseConnection(), "songslist", 15);
        assertEquals(expected, actual);

    }
}