package sample;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SoundBank {
    private static int BYTE_LENGTH = 2116924; // length of sounds in the sound bank in bytes
    Map<String, byte[][]> soundBank = new HashMap<String, byte[][]>();

    public SoundBank(){
        loadSoundBank("C:/Users/Karol/Desktop/AGH/Sequencer_v2/src/SoundBank");
    }

    private void loadSoundBank(String path){
        System.out.println("Loading sounds...");
        File directory = new File(path);
        for(File instrument_folder : directory.listFiles()){
            byte[][] instrument = new byte[13][BYTE_LENGTH];
            int idx = 0;
            for (File sound_path:instrument_folder.listFiles()){
                try {
                    AudioInputStream soundStream = AudioSystem.getAudioInputStream(sound_path);
                    byte[] sound = new byte[BYTE_LENGTH];
                    soundStream.read(sound, 0, BYTE_LENGTH);
                    instrument[idx] = sound;
                    soundStream.close();
                    idx++;
                }
                catch (Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
            soundBank.put(instrument_folder.getName(),instrument);
        }
        System.out.println("Done!");
    }

    public byte[][] getInstrument(String instrument){
        return soundBank.get(instrument);
    }
}
