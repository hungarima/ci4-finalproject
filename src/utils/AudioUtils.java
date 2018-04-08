package utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioUtils {
    public static AudioUtils instance = new AudioUtils();

    private AudioUtils() {}

    public Clip loadSound (String url) {
        File soundFile = new File(url);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            return null;
        }
    }

}

