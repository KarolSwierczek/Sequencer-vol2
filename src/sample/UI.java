package sample;

public class UI{
    public Boolean[] gateMode; //LONG, MULTIPLE, SINGLE, PAUSE
    /*
 if N is number of pulses in a current step:
 LONGG - one long sound lasting N pulses
 MULTIPLE - N short sounds
 SINGLE - one short sound and N-1 pulses-long pause
 PAUSE - N pulses-long pause
 getPulseStatus(gateMode mode) function in Clock class converts this to a bool table
 */
    private boolean play; // is the sequencer playing? !!! this should probably be a function or a status enum !!!
    public int instrumentNumber; // number of instrument in sound bank
    public int tempo; // how long is a step
    public int steps; // number of steps
    public Boolean[] skip; // whitch steps should be skipped
    private int[] pulseCountArray; // how many pulses are there in each step [1-8]
    private int[] pitch; // gate sound height [0-12] + transpose? !!! needs rethinking !!!
    // future feature idea: switch from pitch to CV

    public UI(){
        skip= new Boolean[8];
        gateMode= new Boolean[4];
    }

    public boolean getPlay(){
        return play;
    }

    public Boolean getSkip(int currentStep) {
        return skip[currentStep];
    }

    public int getPulseCount(int currentStep) {
        return pulseCountArray[currentStep];
    }

    public int getPitch(int currentStep) {
        return pitch[currentStep];
    }
}
