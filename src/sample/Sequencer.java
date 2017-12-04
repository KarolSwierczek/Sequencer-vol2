package sample;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class Sequencer {
    //szaleństwo
    private Clock clock;
    private UI ui;
    public Slider tempo;
    public Slider steps;
    public CheckBox skip1,skip2,skip3,skip4,skip5,skip6,skip7,skip8,longg,multiple,single,pause;
    public ComboBox instrument;

    public Sequencer(){
        ui=new UI();
        clock=new Clock();
    }

    public void changetempo()
    {
        //szaleństwo
         clock.setTempo((int)tempo.getValue());
       ui.tempo=(int)tempo.getValue();
    }

    public void changesteps(){
        ui.steps=(int)steps.getValue();
    }
    public void changeskip(){

        ui.skip[0] = skip1.isSelected();
        ui.skip[1] = skip2.isSelected();
        ui.skip[2] = skip3.isSelected();
        ui.skip[3] = skip4.isSelected();
        ui.skip[4] = skip5.isSelected();
        ui.skip[5] = skip6.isSelected();
        ui.skip[6] = skip7.isSelected();
        ui.skip[7] = skip8.isSelected();
    }

    public void changeinstrument(){
        ui.instrumentNumber=(int)instrument.getValue();
    }

    public void changemode(){

        ui.gateMode[0] = longg.isSelected();
        ui.gateMode[1] = multiple.isSelected();
        ui.gateMode[2] = single.isSelected();
        ui.gateMode[3] = pause.isSelected();

    }
}