package com.events;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button submitButton;
    @FXML
    private Button forgotPasswordButton;
    @FXML
    private CheckBox removeInputCheckBox;
    @FXML
    private Label tekst;

    @FXML
    public void initialize(){
        submitButton.setDisable(true);
    }
    @FXML
    public void onButtonClicked(ActionEvent e) {

        if (email.getText().equals("test") && password.getText().equals("test")) {
            System.out.println("LOG: " + email.getText() + " logged in");

        } else {
            System.out.println("LOG: Unknown wrong email: " + email.getText() + " or password");
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            tekst.setText("Done!");
                        }
                    });

                }catch (InterruptedException ex){
                    System.out.println();
                }
            }
        };
        new Thread(runnable).start();

        if(removeInputCheckBox.isSelected()){
            password.clear();
            email.clear();
            submitButton.setDisable(true);

        }
    }
    @FXML
    public void changePassword() {
        System.out.println("Changing password");
    }
    @FXML
    public void handleKeyReleased(){
        String pass = password.getText();
        String mail = email.getText();
        boolean dissableButton = pass.isEmpty() || pass.trim().isEmpty() || mail.isEmpty() || mail.trim().isEmpty();
        submitButton.setDisable(dissableButton);
    }
    @FXML
    public void checkBoxState(){
        if(removeInputCheckBox.isSelected()) System.out.println("Clearing the input");
        else System.out.println("Input stays the same");
    }
}