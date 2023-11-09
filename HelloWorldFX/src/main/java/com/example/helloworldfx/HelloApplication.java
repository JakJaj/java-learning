package com.example.helloworldfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        /*GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);



        Label greeting = new Label("Hello");
        greeting.setTextFill(Color.GREEN);
        greeting.setFont(Font.font("Helvetica",FontWeight.BOLD,70));

        gridPane.getChildren().addAll(greeting);*/
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root,720,340));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}