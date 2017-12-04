package sample;
public class Clock {
    private Settings settings;
    private static float TIME_CONSTANT = 0.5f; // converts time from tempo to ms
    private long lastTime = 0; // time of last while iteration
    private long currentTime = 0; // time of current iteration
    private float timeCount = 0; // time from last pulse
    private int currentStep = 0; // current step number
    private int currentPulse = 0; // current pulse number

    public Clock(Settings s) { settings = s; }


    public void fixedupdate(){
        while(settings.getPlay()){
            if(timeCount >= settings.getTempo()*TIME_CONSTANT){
                timeCount = 0;
            }

            if(timeCount == 0){
                if(currentPulse >= settings.getPulseCount(currentStep)) {
                    currentPulse = 0;
                    currentStep = (currentStep + 1) % settings.getSteps();
                    while (settings.getSkip(currentStep)){
                        currentStep = (currentStep + 1) % settings.getSteps();
                    }
                }
                else{
                    currentPulse++;
                }
                //playback.play(currentStep, currentPulse);
                System.out.println('bip')
            }

            lastTime = currentTime;
            currentTime = System.currentTimeMillis();
            timeCount += currentTime - lastTime;
        }
    }
}


