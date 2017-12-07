package sample;

public class Modulation {
    private Settings settings;

    public Modulation(Settings s) {settings = s;}
//
//    public WavFile getFinalSound(){
//        /*
//        Wavfile instrument = Instruments.getInstrument(UI.instrumentNumber)
//        int pitch = UI.getPitch(currentStep)
//        int length = getSoundLength(UI.getGateMode(currentStep), UI.getPulseCount(currentStep), currentPulse)
//        instrument = modulatePitch(instrument, pitch)
//        return modulateLength(instrument, length)
//
//        or
//
//        Wavfile instrument = Instruments.getInstrument(UI.instrumentNumber,UI.getPitch(currentStep))
//        int length = getSoundLength(UI.getGateMode(currentStep), UI.getPulseCount(currentStep), currentPulse)
//        return modulateLength(instrument, length)
//        */
//    }
//
//
//    private int getSoundLength(UI.gateMode mode, int currentPulseCount, int currentPulse){
//        int[] soundLengthArray = new int[currentPulseCount];
//        //0 - dont play, (1-8) play sound of length 1-8
//        //probably will multiply this by TIME_CONSTANT and give to play() function
//        for(int i = 0; i <= currentPulseCount, i++){
//            soundLengthArray[i] = 0;
//        }
//        //initialising array
//
//        switch(mode){
//            case LONG:
//                soundLengthArray[0] = currentPulseCount;
//                break;
//            case MULTIPLE:
//                for(int i = 0; i <= currentPulseCount, i++){
//                soundLengthArray[i]++;
//            }
//            break;
//            case SINGLE:
//                soundLengthArray[0]++;
//                break;
//            case PAUSE:
//                break;
//        }
//        return soundLengthArray[currentPulse];
//    }
//
//    private WavFile modulateLength(WavFile Instrument, int length){
//        // apply window to instrument
//    }
//
//    private WavFile modulatePitch(WavFile Instrument, int pitch){
//        // shift instrument in pitch but do not affect length
//        // !!! could also choose from instrument samples !!!
//    }
}
