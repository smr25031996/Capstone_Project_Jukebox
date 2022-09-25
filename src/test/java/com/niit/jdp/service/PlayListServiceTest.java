package com.niit.jdp.service;

import com.niit.jdp.repository.SongRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PlayListServiceTest {
    PlayListService playListService;
    SongRepository songRepository;
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        playListService = new PlayListService();
        songRepository = new SongRepository();
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void sortAccordingToGivenType() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        // Checking that the result of the method is not null.
        assertNotEquals(null, playListService.sortAccordingToGivenType("song", songRepository
                .getAll(databaseService.getDatabaseConnection())));

        // Checking that the result of the method is not null.
        assertNotEquals(null, playListService.sortAccordingToGivenType("artist", songRepository
                .getAll(databaseService.getDatabaseConnection())));
        // Checking that the result of the method is not null.
        assertNotEquals(null, playListService.sortAccordingToGivenType("genre", songRepository
                .getAll(databaseService.getDatabaseConnection())));
        // Checking that the result of the method is not null.
        assertNotEquals(null, playListService.sortAccordingToGivenType("album", songRepository
                .getAll(databaseService.getDatabaseConnection())));
    }

}