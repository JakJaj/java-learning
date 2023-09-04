import java.util.ArrayList;

public class Bank {
    private final String name;
    private final ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public Branch findBranch(String name){
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
        if(foundBranch.findCustomer(customerName) == null){
            foundBranch.newCustomer(customerName,initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName,double transaction){
        Branch foundBranch = findBranch(branchName);
        if(foundBranch == null) return false;
        Customer foundCustomer = foundBranch.findCustomer(customerName);
        if(foundCustomer == null) return false;
        foundCustomer.addTransaction(transaction);
        return true;
    }

    public boolean listCustomers(String branchName, boolean printTransaction){
        Branch foundBranch = findBranch(branchName);
        if(foundBranch == null) return false;

        for(Customer customer: foundBranch.getCustomers()){
            System.out.println(customer.getName()  + (printTransaction ? ": " + customer.getTransactions(): ""));
        }
        return true;
    }
}
