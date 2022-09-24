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

    AudioInputStream audioInputStream;
    // current status of clip
    private String status;
    // to store current position
    private long currentFrame;
    // A variable of type Clip.
    private Clip clip;

    /**
     * It takes a song name and a list of songs as parameters, and plays the song with the given name from the given list
     *
     * @param songName the name of the song file
     */
    public void playSong(String songName) {
        String path = "src/main/resources/songslist/" + songName + ".wav";
        try {
            File file = new File(path);
            if (file.exists()) {
                // Creating an audio input stream from the file.
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                // Creating a Clip object.
                clip = AudioSystem.getClip();
                // Opening the audio input stream.
                clip.open(inputStream);
                // Playing the song.
                clip.start();
                status = "play";
                // Creating a scanner object to read the input from the user.
                Scanner scanner = new Scanner(in);
                int choice;
                // do while loop which will run at least once and then check the condition.
                do {
                    out.println("************************************");
                    out.println("Press '1' for Pause ");
                    out.println("Press '2' for resume");
                    out.println("Press '3' for restart");
                    out.println("Press '3' for lopping the Song");
                    out.println("Press '5' for Jump to specific time");
                    out.println("Press '6' for stop");
                    out.println("Please Enter your choice");
                    choice = scanner.nextInt();
                    musicControl(this.clip, choice, songName);
                } while (choice != 6);
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
                //for pausing song
                if (status.equals("paused")) {
                    out.println("audio is already paused");
                } else {
                    this.currentFrame = this.clip.getMicrosecondPosition();
                    clip.stop();
                    status = "paused";
                }
                break;
            case 2:
                //for playing after pausing
                if (status.equals("play")) {
                    out.println("Audio is already being played");
                } else {
                    clip.close();
                    resetSong(songName);
                    clip.setMicrosecondPosition(currentFrame);
                    clip.start();
                }
                break;
            case 3:
                //for restart from beginning
                clip.stop();
                clip.close();
                resetSong(songName);
                currentFrame = 0L;
                clip.setMicrosecondPosition(0);
                clip.start();
                break;
            case 4:
                //for looping
                clip.open();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                out.println("Currently playing song will play in loop");
                break;
            case 5:
                //for jumping to specific time
                out.println("Enter time (" + 0 + ", " + clip.getMicrosecondLength() + ")");
                Scanner scanner = new Scanner(in);
                long pointer = scanner.nextLong();
                if (pointer > 0 && pointer < clip.getMicrosecondLength()) {
                    clip.stop();
                    clip.close();
                    resetSong(songName);
                    currentFrame = pointer;
                    clip.setMicrosecondPosition(pointer);
                    clip.start();
                } else {
                    out.println("please Enter the value between specified range");
                }
                break;
            case 6:
                //for Stopping the music
                currentFrame = 0L;
                clip.stop();
                return;

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



