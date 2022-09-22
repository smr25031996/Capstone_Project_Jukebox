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
import java.util.Scanner;

public class MusicPlayerService {
    /**
     * It takes a song name and a list of songs as parameters, and plays the song with the given name from the given list
     *
     * @param songName the name of the song file
     */
    public void playSongPlaylist(String songName) {
        Scanner scanner = new Scanner(System.in);
        String path = "src/main/resources/songslist/" + songName + ".wav";
        try {
            File file = new File(path);
            if (file.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                // Creating a Clip object.
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                JButton jButton;
                jButton = new JButton("Pause");
                JOptionPane.showMessageDialog(null, "Press Pause to pause PLaying");
                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();
                jButton = new JButton("Resume");
                JOptionPane.showMessageDialog(null, "Press Resume to resume PLaying");
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();
                jButton = new JButton("Stop");
                JOptionPane.showMessageDialog(null, "Press Stop to Stop PLaying");
            } else {
                System.out.println("Can't Find File");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }


}



