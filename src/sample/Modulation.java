package sample;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.File;

public class Modulation {
    private Settings settings;
    private SoundBank soundbank;
    private static int BYTE_LENGTH = 2116924; // length of sounds in the sound bank in bytes
    private static float TIME_LENGTH = 12000; // length of sounds in the sound bank in miliseconds

    public Modulation(Settings s, SoundBank b) {
        settings = s;
        soundbank = b;
    }

    public ByteArrayInputStream getFinalSound(int currentStep, int currentPulse){
        byte[] sound = changeLength(getSound(currentStep),getSoundLength(currentStep,currentPulse));
        if(sound == null){
            return null;
        }
        ByteArrayInputStream byteStream = new ByteArrayInputStream(sound);
        //ByteArrayInputStream byteStream = new ByteArrayInputStream(soundbank.getInstrument(settings.getInstrument())[settings.getPitch()[currentStep]]);
        return byteStream;
    }

    private byte[] getSound(int currentStep){
        byte[][] instrument = soundbank.getInstrument(settings.getInstrument());
        byte[] sound = instrument[settings.getPitch()[currentStep]];
        return sound;
    }

    public byte[] changeLength(byte[] sound, int targetLength){
        if(targetLength == 0){
            return null;
        }
        double pulseTime = settings.TIME_CONSTANT*settings.MAX_TEMPO/(settings.getTempo()+1);
        int byteLength = (int)(BYTE_LENGTH*(targetLength*pulseTime/TIME_LENGTH));
        double realDecay = Math.pow(10, settings.getDecay());
        short[][] shorterSound = byte2short(sound, byteLength);
        for(int i = 0; i < byteLength/4; i++){
            double fadeOut = 1 - Math.pow((double)(i+1)*4/byteLength, realDecay);
            shorterSound[0][i] = (short)(shorterSound[0][i] * fadeOut);
            shorterSound[1][i] = (short)(shorterSound[1][i] * fadeOut);
        }
        return short2byte(shorterSound);
    }

    private int getSoundLength(int currentStep, int currentPulse){
        int gateMode = settings.getGateMode()[currentStep];
        int soundLegth = 0;

        //0 - dont play, (1-8) play sound of length 1-8

        switch(gateMode){
            case 4:
                if(currentPulse == 0){
                    soundLegth =  settings.getPulseCount()[currentStep];
                }
                break;

            case 3:
                soundLegth = 1;
                break;

            case 2:
                if(currentPulse == 0){
                    return 1;
                }
                break;

            case 1:
                break;
        }
        return soundLegth;
    }

    public static short[][] byte2short(byte[] array, int length){
        int shortLength = length/4;
        short[][] shortArray = new short[2][shortLength];
        for(int i = 0; i < 4*shortLength; i+=4) {
           shortArray[0][i/4] = (short)((array[i]  & 0xFF) | (array[i+1] << 8));
           shortArray[1][i/4] = (short)((array[i+2]& 0xFF) | (array[i+3] << 8));
        }
        return shortArray;
    }

    public static byte[] short2byte(short[][] array){
        int length = array[0].length;
        byte[] byteArray = new byte[4*length];
        for(int i = 0; i<4*length; i+=4){
            byteArray[i] = (byte)array[0][i/4];
            byteArray[i+1] = (byte)(array[0][i/4] >> 8);
            byteArray[i+2] = (byte)array[1][i/4];
            byteArray[i+3] = (byte)(array[1][i/4] >> 8);
        }
        return byteArray;
    }

    public void test(){
        try {
            AudioInputStream soundStream = AudioSystem.getAudioInputStream(new File("src/testsine.wav"));
            byte[] sound = new byte[BYTE_LENGTH];
            soundStream.read(sound, 0, BYTE_LENGTH);
            soundStream.close();
            short[][] shortSound = byte2short(sound, 10000);
            for(int sample : shortSound[0]){
                System.out.print(sample);
                System.out.print(" ");
            }
            System.out.println("");
            byte[] sound2 = changeLength(sound, 1);
            short[][] sound3 = byte2short(sound2,10000);
            for(int sample2 : sound3[0]){
                System.out.print(sample2);
                System.out.print(" ");
            }
        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
