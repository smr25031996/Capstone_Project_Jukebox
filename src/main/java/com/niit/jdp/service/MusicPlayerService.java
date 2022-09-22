/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class MusicPlayerService {
    /**
     * It takes a song name and a list of songs as parameters, and plays the song with the given name from the given list
     *
     * @param songName the name of the song file
     */
    public void playSongPlaylist(String songName) {
        String path = "src/main/resources/songslist/" + songName + ".wav";
        try {
            File file = new File(path);
            if (file.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                // Creating a Clip object.
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                JOptionPane.showConfirmDialog(null, "Would you like to 'Loop' the Song?", "Music Player", JOptionPane.YES_NO_OPTION);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                JOptionPane.showConfirmDialog(null, "Would you like to 'Pause' the Song?", "Music Player", JOptionPane.YES_NO_OPTION);
                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();
                JOptionPane.showConfirmDialog(null, "Would you like to 'Resume' the Song?", "Music Player", JOptionPane.YES_NO_OPTION);
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();
                JOptionPane.showConfirmDialog(null, "Would you like to 'Stop' the Song?", "Music Player", JOptionPane.YES_NO_OPTION);
            } else {
                System.out.println("Can't Find File");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }


}



