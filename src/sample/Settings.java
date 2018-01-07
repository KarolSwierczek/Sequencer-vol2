package sample;

public class Settings {

    private boolean Play;
    private int Tempo;
    // total number of steps
    private int Steps;
    //Skip - zwraca ktore z stepow mamy pominac(wartsoc true)
    private boolean[] Skip;
    //PulseCount - zwraca wartosci w przedziale 1-8 z kazdego slidera tak jak na obrazku
    private int[] PulseCount;
    //gateMode - zwraca wartosci 1-4 z kazdego slidera tak jak na obrazku
    //0 -LONG - one long sound lasting N pulses
    //1 -MULTIPLE - N short sounds
    //2 -SINGLE - one short sound and N-1 pulses-long pause
    //3 -PAUSE - N pulses-long pause
    private int[] gateMode;
    private String Instrument;
    private int[] Pitch;
    private double Decay;
    public static double TIME_CONSTANT = 200;
    public static double MAX_TEMPO = 8;


    public Settings() {
        // values below are assigned for testing purposes
        //Skip = new boolean[8];
        Decay = 1;
    }


    public boolean getPlay() { return Play; }
    public int getTempo() { return Tempo; }
    public int getSteps() { return Steps; }
    public boolean[] getSkip() { return Skip; }
    public int[] getPulseCount() { return PulseCount; }
    public int[] getGateMode() { return gateMode; }
    public String getInstrument() { return Instrument; }
    public int[] getPitch() { return Pitch; }
    public double getDecay() { return Decay; }


    public void setPlay(boolean play){ Play=play;}
    public void setTempo(int tempo){ Tempo=tempo; }
    public void setSteps(int steps){Steps=steps;}
    public void setSkip(boolean [] skip){ Skip=skip; }
    public void setPulseCount(int [] pulse){PulseCount=pulse;}
    public void setGateMode(int [] gatemode){ gateMode=gatemode; }
    public void setInstrument(String instrument){ Instrument=instrument; }
    public void setPitch(int []pitch){ Pitch = pitch; }
    public void setDecay(double decay){ Decay = decay; }
}
