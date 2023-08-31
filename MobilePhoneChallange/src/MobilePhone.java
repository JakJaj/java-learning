import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList <Contact> myContacts= new ArrayList<>();

    public MobilePhone(String phoneNumber){
        myNumber = phoneNumber;
    }

    public boolean addNewContact(Contact contact){
        if (myContacts.contains(contact)) return false;
        myContacts.add(contact);
        return true;
    }
    
}
