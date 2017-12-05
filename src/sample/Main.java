package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Settings settings = new Settings();
        Clock clock = new Clock(settings);
        Playback playback = new Playback();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));

        // Metoda load tworzy zmienną UI
        Parent root = (Parent)fxmlLoader.load();

        // Pobieramy stworzoną wcześniej zmienną UI i przypisujemy do niej settings
        UI ui = fxmlLoader.getController();
        ui.setSettings(settings);
        ui.setClock(clock);

        primaryStage.setTitle("Sekwencer");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }
}