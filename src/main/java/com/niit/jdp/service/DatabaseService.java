/*
 * Author Name: Shubham Rajput
 * Date: 21-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.err;
import static java.lang.System.out;

public class DatabaseService {

    // the URL of the database
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";

    // the credentials of the user trying to log in to the database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rshubham@13";

    // a private field to store the reference of the connection object
    private Connection databaseConnection;

    public DatabaseService() {
        this.databaseConnection = null;
    }

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }

    // a method that can connect to the database

    /**
     * The function `connect()` loads the JDBC driver into the program memory, creates a connection object using the
     * DriverManager class, and checks if the connection is successful
     *
     * @return A boolean value.
     */
    public boolean connect() throws ClassNotFoundException, SQLException {
        // 1. load the jdbc driver into the program memory
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. create a connection object using the DriverManager class
        databaseConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. check if the connection is successful
        return databaseConnection != null;
    }

    public void printConnectionStatus() {
        if (databaseConnection != null) {
            out.println("Connected to the database");
        } else {
            err.println("Not connected to the database");
        }
    }
}
