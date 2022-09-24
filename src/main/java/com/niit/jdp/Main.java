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

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, RuntimeException, ArtistNotFoundException, SongNotFoundException {
        out.println("******************** Wel Come to the World of Songs ********************");
        ControlService controlService = new ControlService();
        // Calling the menu() function.
        controlService.songMenu();
    }

}

