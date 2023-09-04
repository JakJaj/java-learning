import java.util.ArrayList;

public class Branch {
    private  String name;
    private  ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String customerName){
        for(Customer element: customers){
            if(element.getName().equals(customerName)) return element;
        }
        return null;
    }
    public boolean newCustomer(String name, double initialTransaction){
        if(findCustomer(name) == null){
            customers.add(new Customer(name,initialTransaction));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String name, double transaction){
        Customer foundCustomer = findCustomer(name);
        if(foundCustomer == null){
            return false;
        }
        foundCustomer.addTransaction(transaction);
        return true;
    }
}
