module com.example.controlls {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.controlls to javafx.fxml;
    exports com.example.controlls;
}