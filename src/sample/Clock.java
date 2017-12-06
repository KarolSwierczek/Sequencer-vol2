package sample;

public class Clock extends Thread{
    private Settings settings;
    private Object lock;
    private boolean exit = false;
    private static float TIME_CONSTANT = 200000000.0f; // converts time from tempo to ms
    private static float MAX_TEMPO = 8;
    private long lastTime = 0; // time of last while iteration
    private long currentTime = 0; // time of current iteration
    private float timeCount = 0; // time from last pulse
    private int currentStep = 0; // current step number
    private int currentPulse = 0; // current pulse number

    //for testing purposes only!
    private static String[] ticks = {"bip", "bop"};

    public Clock(Settings s, Object l) {
        settings = s;
        lock = l;
    }

    public void run(){
        while(!exit) {
            System.out.println("running");
            synchronized (lock) {
                while (!settings.getPlay()) {
                    try {
                        System.out.println("waiting");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            currentTime = System.nanoTime();
            while (settings.getPlay()) {
                if (timeCount >= MAX_TEMPO/(settings.getTempo()+1) * TIME_CONSTANT) {

                    timeCount = 0;
                }

                if (timeCount == 0) {
                    if (currentPulse >= settings.getPulseCount()[currentStep]-1) {
                        currentPulse = 0;
                        currentStep = (currentStep + 1) % settings.getSteps();
                        while (settings.getSkip()[currentStep]) {
                            currentStep = (currentStep + 1) % settings.getSteps();
                        }
                        System.out.println(currentStep+1);
                    } else {
                        currentPulse++;
                    }
                    System.out.println(ticks[currentPulse%2]);
                    //playback.play(currentStep, currentPulse);
                }

                lastTime = currentTime;
                currentTime = System.nanoTime();
                timeCount += currentTime - lastTime;
            }
        }
    }

    public void setExit(boolean e) {exit = e; System.out.println("stopping clock...");}
}


