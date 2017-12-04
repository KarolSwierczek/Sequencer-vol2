

public class Sequencer {
    private Settings settings;
    private Clock clock;
    private Playback playback;
    private UI ui;


    public Sequencer(){
    settings = new Settings();
    clock = new Clock(settings);
    ui = new UI();
    playback = new Playback();
    }

}