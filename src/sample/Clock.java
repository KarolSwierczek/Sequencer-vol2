package sample;

public class Clock extends Thread{
    private Settings settings;
    private Playback playback;
    private Object lock;
    private boolean exit = false;

    private long lastTime = 0; // time of last while iteration
    private long currentTime = 0; // time of current iteration
    private double timeCount = 0; // time from last pulse
    private int currentStep = 0; // current step number
    private int currentPulse = 0; // current pulse number

    public Clock(Settings s, Playback p, Object l) {
        settings = s;
        playback = p;
        lock = l;
    }

    public void run(){
        while(!exit) {
            synchronized (lock) {
                while (!settings.getPlay()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            currentTime = System.currentTimeMillis();
            timeCount = settings.MAX_TEMPO/(settings.getTempo()+1) * settings.TIME_CONSTANT;
            while (settings.getPlay()) {
                if (timeCount >= settings.MAX_TEMPO/(settings.getTempo()+1) * settings.TIME_CONSTANT) {
                    timeCount = 0;
                    if (currentPulse >= settings.getPulseCount()[currentStep]-1) {
                        currentPulse = 0;
                        currentStep = (currentStep + 1) % settings.getSteps();
                        while (settings.getSkip()[currentStep]) {
                            currentStep = (currentStep + 1) % settings.getSteps();
                        }
                    }
                    else {
                        currentPulse++;
                    }
                    playback.playSound(currentStep, currentPulse);
                }
                lastTime = currentTime;
                currentTime = System.currentTimeMillis();
                timeCount += currentTime - lastTime;
            }
        }
    }

    public void setExit(boolean e) {exit = e;}
}


