package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Settings settings = new Settings();
        Playback playback = new Playback(settings);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));

        // Metoda load tworzy zmienną UI
        Parent root = (Parent)fxmlLoader.load();

        // Pobieramy stworzoną wcześniej zmienną UI i przypisujemy do niej settings
        UI ui = fxmlLoader.getController();
        ui.setSettings(settings);

        Clock clock = new Clock(settings, playback, ui.getLock());

        clock.start();
        ui.start();


        primaryStage.setTitle("Sekwencer");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setOnHidden((WindowEvent event) -> {
            clock.setExit(true);
            System.out.println("exiting...");
            Platform.exit();
            System.exit(0);
        });
        primaryStage.show();
    }
}