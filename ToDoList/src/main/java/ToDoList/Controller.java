package ToDoList;

import ToDoList.DataModels.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView todolistview;
    @FXML
    private TextArea textArea;
    @FXML
    private Label deadLine;
    public void initialize(){
        ToDoItem item1 = new ToDoItem("Wash car","Go and wash your car cause it is getting really dirty", LocalDate.of(2023, Month.NOVEMBER,10));
        ToDoItem item2 = new ToDoItem("Learn Spring","Improve your knowledge of Spring framework", LocalDate.of(2024, Month.MARCH,19));
        ToDoItem item3 = new ToDoItem("Do Java Homework","Do latest homework for Java class", LocalDate.of(2023, Month.NOVEMBER,23));
        ToDoItem item4 = new ToDoItem("Get Diamond in Lol","Rank up to the Diamond by the end of the season", LocalDate.of(2023, Month.DECEMBER,20));
        ToDoItem item5 = new ToDoItem("Pain a picture","Make something artsy and paint a nice picture", LocalDate.of(2023, Month.DECEMBER,29));
        toDoItems = new ArrayList<ToDoItem>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);
        toDoItems.add(item5);
        todolistview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object object, Object t1) {
                if(t1 != null){
                    ToDoItem item = (ToDoItem) todolistview.getSelectionModel().getSelectedItem();
                    textArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM yyyy");
                    deadLine.setText(df.format(item.getDeadLine()));
                }
            }
        });
        todolistview.getItems().setAll(toDoItems);
        todolistview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todolistview.getSelectionModel().selectFirst();

    }
}