package com.events;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
}