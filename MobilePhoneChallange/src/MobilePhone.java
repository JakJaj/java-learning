import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList <Contact> myContacts;

    public MobilePhone(String phoneNumber){
        myNumber = phoneNumber;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if (myContacts.contains(contact)) return false;
        myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        if (myContacts.contains(oldContact)){
            int idx = myContacts.indexOf(oldContact);
            myContacts.set(idx,newContact);
            return true;
        }
        return false;
    }
    public boolean removeContact(Contact contact){
        if(myContacts.contains(contact)){
            myContacts.remove(contact);
            return true;
        }
        return false;
    }
    private int findContact(Contact contact){
        if(myContacts.contains(contact)){
            int idx = myContacts.indexOf(contact);
            return idx;
        }
        return -1;
    }
    private int findContact(String contact){
        for(Contact element: myContacts){
            if(element.getName().contentEquals(contact)) return myContacts.indexOf(element);
        }
        return -1;
    }

    public Contact queryContact(String contact){
        for(Contact element: myContacts){
            if(element.getName().contentEquals(contact)) return  element;
        }
        return null;
    }
    public void printContacts(){
        System.out.println("Contact List:");
        for(Contact element: myContacts){
            System.out.println(element.getName() + " -> " + element.getPhoneNumber());
        }
    }
}
