/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.exception.ArtistNotFoundException;
import com.niit.jdp.exception.SongNotFoundException;
import com.niit.jdp.service.ControlService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, RuntimeException, ArtistNotFoundException, SongNotFoundException {


        // Creating an object of the ControlService class.
        ControlService controlService = new ControlService();

        // Calling the songMenu() method of the ControlService class.
        controlService.songMenu();


    }

}

