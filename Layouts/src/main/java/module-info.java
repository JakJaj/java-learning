module com.example.layouts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.layouts to javafx.fxml;
    exports com.example.layouts;
}