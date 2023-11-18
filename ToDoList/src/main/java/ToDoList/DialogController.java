package ToDoList;

import ToDoList.DataModels.ToDoData;
import ToDoList.DataModels.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescription;
    @FXML
    private TextArea details;
    @FXML
    private DatePicker deadline;

    public ToDoItem procesResult(){
        String shortDescr = shortDescription.getText().trim();
        String detail = details.getText().trim();
        LocalDate date = deadline.getValue();
        ToDoItem item = new ToDoItem(shortDescr,detail,date);
        ToDoData.getInstance().addToDoItem(item);
        return item;
    }
}
