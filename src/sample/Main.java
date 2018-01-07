package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Settings settings = new Settings();
        SoundBank soundbank = new SoundBank();
        Modulation modulation = new Modulation(settings, soundbank);
        Playback playback = new Playback(modulation);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));

        // Metoda load tworzy zmienną UI
        Parent root = (Parent)fxmlLoader.load();

        // Pobieramy stworzoną wcześniej zmienną UI i przypisujemy do niej settings
        UI ui = fxmlLoader.getController();
        ui.setSettings(settings);

        Clock clock = new Clock(settings, playback, ui.getLock());

        clock.start();
        ui.start();

        Font.loadFont(getClass().getResourceAsStream("lcddot.ttf"), 10);
        primaryStage.setTitle("Sekwencer");
        Scene scene = new Scene(root, 800, 596 );
        scene.getStylesheets().add(UI.class.getResource("Skins.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setOnHidden((WindowEvent event) -> {
            clock.setExit(true);
            System.out.println("Exiting...");
            Platform.exit();
            System.exit(0);
        });
        primaryStage.show();
    }
}