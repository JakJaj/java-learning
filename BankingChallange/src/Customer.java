import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final ArrayList <Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        transactions = new ArrayList<>(List.of(initialTransaction));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction){
        transactions.add(transaction);
    }
}
