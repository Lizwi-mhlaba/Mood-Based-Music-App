package com.moodifyx;

import java.io.File;
import javax.sound.sampled.*;

public class SongPlayer {

    private static Clip clip;

    public static void play(String filePath) {
        try {
            // Stop and close any currently playing clip
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // Start playing the audio

        } catch (Exception e) {
            System.out.println("Error Playing Sound: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
