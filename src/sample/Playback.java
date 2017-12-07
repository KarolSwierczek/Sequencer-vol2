package sample;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class Playback{
    //to mozna zmienic na int czy cos latwiej bedzie to ogarnac, gdy bedziemy mieli jakas baze
    // eee tam zrobimy mapę
    private String Instrument;
    private Settings settings;
    Map<String, WavFile[]> soundBank = new HashMap<String, WavFile[]>();

    public Playback(Settings s){
        settings=s;
        loadSoundBank("C:/Users/Karol/Desktop/AGH/Sequencer_v2/src/SoundBank");
    }

    public void playSound(int currentStep, int currentPulse){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Users/Karol/Desktop/AGH/Sequencer_v2/src/SoundBank/Lead_Terc/Lead_Terc_"+String.valueOf(settings.getPitch()[currentStep]+1)+".wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (Exception e){
            System.out.println("Error with playing sound");
            e.printStackTrace();
        }
        //play Modulation.getFinalSound(currentStep, currentPulse)
    }

    private void loadSoundBank(String path){
        File directory = new File(path);
        for(File instrument_folder : directory.listFiles()){
            WavFile[] instrument = new WavFile[13];
            int idx = 0;
            for (File sound_path:instrument_folder.listFiles()){
                try {
                    WavFile sound = WavFile.openWavFile(sound_path);
                    //the 3 lines below are for testing
                    System.out.print("index: ");
                    System.out.println(idx);
                    sound.display();
                    instrument[idx] = sound;
                    idx++;
                }
                catch(Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }
            }

            soundBank.put(instrument_folder.getName(),instrument);
        }
    }
}
