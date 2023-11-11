module com.example.events {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.events to javafx.fxml;
    exports com.events;
}