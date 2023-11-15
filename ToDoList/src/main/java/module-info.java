module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens ToDoList to javafx.fxml;
    exports ToDoList;
}