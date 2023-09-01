import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

record Place (String name, int distance){
    @Override
    public String toString() {
        return  name + " - (" + distance + ")";
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        Place Adelaide = new Place("Adelaide",1374);
        addPlace(placesToVisit,Adelaide);
        addPlace(placesToVisit, new Place("Brisbane",917));
        addPlace(placesToVisit,new Place("Perth", 3923));
        addPlace(placesToVisit,new Place("Alice Springs",2771));
        addPlace(placesToVisit,new Place("Darwin",3972));
        addPlace(placesToVisit,new Place("Melbourne",877));
        addPlace(placesToVisit,new Place("Sidney",0));
        ListIterator<Place> placeListIterator = placesToVisit.listIterator();
        //                             init                             //
        boolean Onflag = true;
        boolean forewardFlag = false;
        boolean backwardFlag = true;
        printMenu(forewardFlag,backwardFlag);
        while (Onflag){

            if (!placeListIterator.hasPrevious()) backwardFlag = true;
            else backwardFlag = false;
            if (!placeListIterator.hasNext()) forewardFlag = true;
            else  forewardFlag = false;
            String input = scanner.nextLine();

            switch (input){
                case "Q", "q", "Quit", "quit" -> {
                    try {
                        System.out.println("Thanks for using places app!");
                        System.out.println("Quiting");
                        Thread.sleep(1000);
                        System.out.println("Quiting.");
                        Thread.sleep(2000);
                        System.out.println("Quiting..");
                        Thread.sleep(500);
                        System.out.println("Quiting...");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    Onflag = false;

                }
                case "F", "f", "Forward", "forward" -> {
                    if(forewardFlag) System.out.println("Operation unavailable\n");
                    else {
                        System.out.println(placeListIterator.next());
                    }
                }
                case "B", "b", "Backward", "backward" ->{
                    if(backwardFlag) System.out.println("Operation unavailable\n");
                    else {
                        System.out.println(placeListIterator.previous());
                    }
                }
                case "L", "l", "List", "list", "List Places", "list places", "ListPlaces", "listplaces" ->{
                    for(int i = 0; i < placesToVisit.size(); i++){
                        System.out.println(placesToVisit.get(i));
                    }
                }
                case "M", "m", "Menu", "menu" -> printMenu(forewardFlag,backwardFlag);
            }
        }


    }

    public static void addPlace(LinkedList<Place> list, Place place){
        if(list.contains(place)) {
            System.out.println("Place already in a list!");
            return;
        }
        for(Place p: list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate: " + place);
                return;
            }
        }
        int idx = 0;
        for(var listPlace: list){
            if(listPlace.distance() > place.distance()){
                list.add(idx,place);
                return;
            }
            idx++;
        }
        list.add(place);
    }

    public static void printMenu(boolean cantForwardFlag, boolean cantBackwardFlag){
        if (cantForwardFlag) {
            System.out.println("\nAvailable actions (select word or letter)");
            System.out.println("(F)orward - Unavailable" );
            System.out.println("(B)ackward");
            System.out.println("(L)ist Places");
            System.out.println("(M)enu");
            System.out.println("(Q)uit\n");
        }
        else if (cantBackwardFlag){
            System.out.println("\nAvailable actions (select word or letter)");
            System.out.println("(F)orward");
            System.out.println("(B)ackward - Unavailable");
            System.out.println("(L)ist Places");
            System.out.println("(M)enu");
            System.out.println("(Q)uit\n");
        }
        else {
            System.out.println("\nAvailable actions (select word or letter)");
            System.out.println("(F)orward");
            System.out.println("(B)ackward");
            System.out.println("(L)ist Places");
            System.out.println("(M)enu");
            System.out.println("(Q)uit\n");
        }
    }
}