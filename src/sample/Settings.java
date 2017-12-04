package sample;

public class Settings {

    private int Tempo= 0;
    //gateMode - zwraca wartosci 1-4 z kazdego slidera tak jak na obrazku
    //1 -LONGG - one long sound lasting N pulses
    //2 -MULTIPLE - N short sounds
    //3 -SINGLE - one short sound and N-1 pulses-long pause
    //4 -PAUSE - N pulses-long pause
    private int[] gateMode;
    //Skip - zwraca ktore z stepow mamy pominac(wartsoc true)
    private Boolean[] Skip;
    private Boolean Play;
    //PulseCount - zwraca wartosci w przedziale 1-8 z kazdego slidera tak jak na obrazku
    private int[] PulseCount;
    private int Step; // current step number
    private String Instrument;


    public int getTempo() { return Tempo; }
    public int[] getGateMode() { return gateMode; }
    public Boolean[] getSkip() { return Skip; }
    public Boolean getPlay() { return Play; }
    public int[] getPulseCount() { return PulseCount; }
    public int getStep() { return Step; }
    public String getInstrument() { return Instrument; }


    public Settings(){ Skip= new Boolean[8]; }

    public void setTempo(int tempo){ Tempo=tempo; }
    public void setGateMode(int [] gatemode){ gateMode=gatemode; }
    public void setSkip(Boolean [] skip){ Skip=skip; }
    public void setPlay(Boolean play){ Play=play;  System.out.println(play);}
    public void setPulseCount(int [] pulse){PulseCount=pulse;}
    public void setStep(int step){Step=step;}
    public void setInstrument(String instrument){ Instrument=instrument; }
}
