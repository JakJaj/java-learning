import java.util.ArrayList;

public class Bank {
    private  String name;
    private  ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    private Branch findBranch(String name){
        for(var branch: branches){
            if(branch.getName().equals(name)){
                return branch;
            }
        }
        return null;
    }
    public boolean addBranch(String name){
        if(findBranch(name) == null){
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }
    public boolean addCustomer(String branchName,String customerName,double initialTransaction){
        Branch foundBranch = findBranch(branchName);
        if(foundBranch == null){
            return false;
        }

        for(Customer customer: foundBranch.getCustomers()) {
            if (customer.getName().equals(customerName)){
                return false;
            }
        }
        foundBranch.newCustomer(customerName, initialTransaction);
        return true;
    }

    public boolean addCustomerTransaction(String branchName, String customerName,double transaction){
        Branch foundBranch = findBranch(branchName);
        if(foundBranch == null) return false;

        for(Customer customer: foundBranch.getCustomers()){
            if(customer.getName().equals(customerName)){
                customer.addTransaction(transaction);
                return true;
            }
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransaction){
        Branch foundBranch = findBranch(branchName);
        if(foundBranch == null) return false;
        System.out.println("Customer details for branch " + foundBranch.getName());
        for(Customer customer: foundBranch.getCustomers()){
            if(printTransaction){
                System.out.println("Customer: " + customer.getName() + "[" + (foundBranch.getCustomers().indexOf(customer) + 1) + "]");
                System.out.println("Transactions");
                for(int i = 0; i < customer.getTransactions().size(); i++){
                    System.out.println("[" + (i + 1)+ "]  Amount " + customer.getTransactions().get(i));

                }
            }else {
                System.out.println("Customer: " + customer.getName() + "[" + (foundBranch.getCustomers().indexOf(customer) + 1) + "]");
            }
        }
        return true;
    }
}
