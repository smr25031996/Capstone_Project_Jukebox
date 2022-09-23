/*
 * Author Name: Shubham Rajput
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class MusicPlayerService {
    File file;

    // to store current position
    long currentFrame;
    // current status of clip
    String status = "playing";

    // A variable of type Clip.
    Clip clip;
    AudioInputStream audioInputStream;


    /**
     * It takes a song name and a list of songs as parameters, and plays the song with the given name from the given list
     *
     * @param songName the name of the song file
     */
    public void playSongPlaylist(String songName) {
        String path = "src/main/resources/songslist/" + songName + ".wav";
        try {
            file = new File(path);
            if (file.exists()) {
                // Creating an audio input stream from the file.
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                // Creating a Clip object.
                clip = AudioSystem.getClip();
                // Opening the audio input stream.
                clip.open(inputStream);
                // Playing the song.
                clip.start();
                // Creating a scanner object to read the input from the user.
                Scanner scanner = new Scanner(in);
                int choice;
                // do while loop which will run at least once and then check the condition.
                do {
                    out.println("Press '1' for Pause ");
                    out.println("Press '2' for resume");
                    out.println("Press '3' for restart");
                    out.println("Press '4' for Jump to specific time");
                    out.println("Press '5' for stop");
                    out.println("Please Enter your choice");
                    choice = scanner.nextInt();
                    musicControl(this.clip, choice, songName);
                } while (choice != 5);
                // Closing the scanner object.
                scanner.close();
            } else {
                err.println("Song not Found");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void musicControl(Clip clip, int choice, String songName) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        switch (choice) {
            case 1:
                if (status.equals("paused")) {
                    out.println("audio is already paused");
                } else {
                    this.currentFrame = this.clip.getMicrosecondPosition();
                    clip.stop();
                    status = "paused";
                }
                break;
            case 2:
                if (status.equals("play")) {
                    out.println("Audio is already " + "being played");
                } else {
                    clip.close();
                    resetSong(songName);
                    clip.setMicrosecondPosition(currentFrame);
                    clip.start();
                }
                break;
            case 3:
                clip.stop();
                clip.close();
                resetSong(songName);
                currentFrame = 0L;
                clip.setMicrosecondPosition(0);
                clip.start();
                break;
            case 4:
                out.println("Enter time (" + 0 + ", " + clip.getMicrosecondLength() + ")");
                Scanner sc = new Scanner(in);
                long c = sc.nextLong();
                if (c > 0 && c < clip.getMicrosecondLength()) {
                    clip.stop();
                    clip.close();
                    resetSong(songName);
                    currentFrame = c;
                    clip.setMicrosecondPosition(c);
                    clip.start();
                }
                break;
            case 5:
                currentFrame = 0L;
                clip.stop();
                clip.close();
                break;
            default:
                out.println("Wrong Choice");
                break;
        }
    }

    // Method to reset audio stream
    public void resetSong(String songName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String path = "src/main/resources/songslist/" + songName + ".wav";
        audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}



