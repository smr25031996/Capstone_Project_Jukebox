package com.niit.jdp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseServiceTest {
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        databaseService = null;
    }

    @Test
    void connect() throws SQLException, ClassNotFoundException {
        boolean expected = true;
        boolean actual = databaseService.connect();
        assertEquals(expected, actual);
    }

}