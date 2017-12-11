package sample;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;


public class Playback{
    private Modulation modulation;
    private static int FRAME_LENGTH = 529200; //length of a sound in frames
    private AudioFormat audioFormat; // should be static?

    public Playback(Modulation m){
        modulation = m;
        audioFormat = new AudioFormat(44100, 16, 2, true, false);
    }

    public void playSound(int currentStep, int currentPulse){
        try{
            ByteArrayInputStream sound = modulation.getFinalSound(currentStep, currentPulse);
            if(sound != null) {
                AudioInputStream soundStream = new AudioInputStream(sound, audioFormat, FRAME_LENGTH);
                Clip clip = AudioSystem.getClip();
                clip.open(soundStream);
                clip.start();
                soundStream.close();
            }
        }catch (Exception e){
            System.out.println("Error with playing sound");
            e.printStackTrace();
        }
    }
}
