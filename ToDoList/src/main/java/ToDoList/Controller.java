package ToDoList;

import ToDoList.DataModels.ToDoData;
import ToDoList.DataModels.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


public class Controller {
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView todolistview;
    @FXML
    private TextArea textArea;
    @FXML
    private Label deadLine;
    @FXML
    private BorderPane mainBorderPane;
    public void initialize(){
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
        todolistview.setItems(ToDoData.getInstance().getToDoItems());
        todolistview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todolistview.getSelectionModel().selectFirst();
        todolistview.setCellFactory(new Callback<ListView<ToDoItem>, ListCell<ToDoItem>>() {
            @Override
            public ListCell<ToDoItem> call(ListView param) {
                ListCell<ToDoItem> cell = new ListCell<ToDoItem>() {
                    @Override
                    protected void updateItem(ToDoItem item, boolean b) {
                        super.updateItem(item, b);
                        if(b){
                            setText(null);
                        }else{
                            setText(item.getShortDescription());
                            if(item.getDeadLine().isBefore(LocalDate.now().plusDays(1))){
                                setTextFill(Color.RED);
                            }else if(item.getDeadLine().equals(LocalDate.now().plusDays(1))){
                                setTextFill(Color.PURPLE);
                            }
                        }
                    }
                };
                return cell;
            }
        });
    }
    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Create New Todo Task");
        dialog.setHeaderText("Use this dialog to create new task");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ToDoItemDialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            ToDoItem item = controller.procesResult();
            todolistview.getSelectionModel().select(item);

        }

    }
}