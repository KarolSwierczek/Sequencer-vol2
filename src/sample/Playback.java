package sample;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Playback{
    //to mozna zmienic na int czy cos latwiej bedzie to ogarnac, gdy bedziemy mieli jakas baze
    private String Instrument;
    private Settings settings;

    public Playback(Settings s){settings=s;}

    public void playSound(int currentStep, int currentPulse){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Users/NinaNina/Desktop/Studia!/Java/Java - projekt/src/sounds/square_"+String.valueOf(settings.getPitch()[currentStep]+1)+".wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (Exception e){
            System.out.println("Error with playing sound");
            e.printStackTrace();
        }
        //play Modulation.getFinalSound(currentStep, currentPulse)
    }
}
