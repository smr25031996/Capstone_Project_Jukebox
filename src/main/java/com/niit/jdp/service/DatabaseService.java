/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import java.sql.Connection;

public class DatabaseService {

    // the URL of the database
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";

    // the credentials of the user trying to log in to the database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rshubham@13";

    // a private field to store the reference of the connection object
    private Connection databaseConnection;

}
