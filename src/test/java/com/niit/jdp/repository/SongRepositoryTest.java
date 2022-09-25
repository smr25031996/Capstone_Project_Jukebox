package com.niit.jdp.repository;

import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void getAll() {


    }

    @Test
    void getSongById() {
    }

    @Test
    void getSongBySongName() {
    }

    @Test
    void getSongByAlbum() {
    }

    @Test
    void getSongByGenre() {
    }

    @Test
    void getSongByArtists() {
    }
}