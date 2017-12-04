package sample;//public class Clock {
//
//    private static float TIME_CONSTANT = 0.5f; // converts time from tempo to ms
//    private long lastTime = 0; // time of last while iteration
//    private long currentTime = 0; // time of current iteration
//    private float timeCount = 0; // time from last pulse
//    private int currentStep = 0; // current step number
//    private int currentPulse = 0; // current pulse number

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
//}


