package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class Sequencer {
    private Settings settings;
    private Clock clock;
    private Playback playback;
    @FXML
    private CheckBox skip1,skip2,skip3,skip4,skip5,skip6,skip7,skip8,play;
    @FXML
    private ComboBox instrument;
    @FXML
    private Slider PulseCount1,PulseCount2,PulseCount3,PulseCount4,PulseCount5,PulseCount6,PulseCount7,PulseCount8,
            Gate1,Gate2,Gate3,Gate4,Gate5,Gate6,Gate7,Gate8,steps,tempo;


    public Sequencer(){
    settings = new Settings();
    clock=new Clock(settings);
    }

    public void changeplay(){ settings.setPlay(!play.isSelected());}

    public void changeinstrument(){settings.setInstrument(instrument.getValue().toString());}

    public void changetempo() { settings.setTempo((int)tempo.getValue()); }

    public void changesteps(){  settings.setStep((int)steps.getValue());  }

    public void changeskip(){
        settings.setSkip(new Boolean[]{
            skip1.isSelected(),
            skip2.isSelected(),
            skip3.isSelected(),
            skip4.isSelected(),
            skip5.isSelected(),
            skip6.isSelected(),
            skip7.isSelected(),
            skip8.isSelected()
        });
    }

    public void changepulsecounts(){
        settings.setPulseCount(new int[]{
            (int)PulseCount1.getValue(),
            (int)PulseCount2.getValue(),
            (int)PulseCount3.getValue(),
            (int)PulseCount4.getValue(),
            (int)PulseCount5.getValue(),
            (int)PulseCount6.getValue(),
            (int)PulseCount7.getValue(),
            (int)PulseCount8.getValue(),

        });
    }

    public void changemode(){
        settings.setGateMode(new int[]{
            (int)Gate1.getValue(),
            (int)Gate2.getValue(),
            (int)Gate3.getValue(),
            (int)Gate4.getValue(),
            (int)Gate5.getValue(),
            (int)Gate6.getValue(),
            (int)Gate7.getValue(),
            (int)Gate8.getValue(),

        });
    }
}