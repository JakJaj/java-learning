public class Main {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone("123123123");
        Contact adam = new Contact("Adam","321321321");

        mobilePhone.printContacts();
        mobilePhone.addNewContact(adam);
        mobilePhone.printContacts();
        System.out.println(mobilePhone.addNewContact(adam));
    }
}