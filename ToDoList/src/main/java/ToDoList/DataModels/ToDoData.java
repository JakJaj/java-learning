package ToDoList.DataModels;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class ToDoData {
    private static ToDoData instance = new ToDoData();
    private static String filename = "ToDoListItems.txt";
    private List<ToDoItem> toDoItems;
    private DateTimeFormatter dateFormater;

    public static ToDoData getInstance(){
        return instance;
    }
    private ToDoData(){
        dateFormater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(List<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }

    public void loadToDoItems() throws IOException{
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while ((input = br.readLine()) != null){
                String[] itemsPieces = input.split("\t");

                String shortDesc = itemsPieces[0];
                String details = itemsPieces[1];
                String dateString = itemsPieces[2];
                LocalDate date = LocalDate.parse(dateString, dateFormater);
                ToDoItem toDoItem = new ToDoItem(shortDesc,details,date);
                toDoItems.add(toDoItem);

            }
        }
        finally {
            if(br != null){
                br.close();
            }
        }
    }
    public void storeToDoItems() throws IOException{
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try{
            Iterator<ToDoItem> iter = toDoItems.iterator();
            while (iter.hasNext()){
                ToDoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s\t",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadLine().format(dateFormater)));
                bw.newLine();
            }
        }
        finally {
            if(bw != null){
                bw.close();
            }
        }
    }
}
