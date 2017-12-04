package sample;
public class Clock {
    private static float TIME_CONSTANT = 0.5f; // converts time from tempo to ms
    private long lastTime = 0; // time of last while iteration
    private long currentTime = 0; // time of current iteration
    private float timeCount = 0; // time from last pulse
    private int currentStep = 0; // current step number
    private int currentPulse = 0; // current pulse number

    //zmienne zmieniane w interfejsie
    private int currentTempo= 0;
    private int currentSkip= 0;
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

    public Clock(){
        Skip= new Boolean[8];
    }
    //szalenstwo
    public void setTempo(int tempo){ currentTempo=tempo; }

    public void setStep(int step){ currentStep=step;}

    public void setPlay(Boolean play){ Play=play;  System.out.println(play);}

    public void setGateMode(int [] gatemode){ gateMode=gatemode; }

    public void setSkip(Boolean [] skip){ Skip=skip; }

    public void setPulseCount(int [] pulse){PulseCount=pulse;}

//    public void update(boolean play){
//        while(UI.getPlay()){
//            UI.updateUI();
//
//            if(timeCount >= UI.getTempo()*TIME_CONSTANT){
//                timeCount = 0;
//            }
//
//            if(timeCount == 0){
//                if(currentPulse >= UI.getPulseCount(currentStep)) {
//                    currentPulse = 0;
//                    currentStep = (currentStep + 1) % UI.getSteps();
//                    while (UI.getSkip(currentStep)){
//                        currentStep = (currentStep + 1) % UI.getSteps();
//                    }
//                }
//                else{
//                    currentPulse++;
//                }
//                Playback.play(currentStep, currentPulse);
//            }
//
//            lastTime = currentTime;
//            currentTime = System.currentTimeMillis();
//            timeCount += currentTime - lastTime;
//        }
//    }
}


