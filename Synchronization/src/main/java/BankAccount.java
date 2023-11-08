public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public  void deposit(double amount){

        try {
            System.out.println("Talking to the teller...");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            double originalBalance = balance;
            balance += amount;

            System.out.println("Starting balance: " + originalBalance + " Deposit: " + amount + " New balance: " + balance);
        }
    }

    public synchronized void withdraw(double amount){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double originalBalance = balance;
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Starting balance: " + originalBalance + " Withdraw: " + amount + " New balance: " + balance);
        }else {
            System.out.println("Starting balance: " + originalBalance + " Withdraw: " + amount + " Insufficient balance!");
        }

    }
}
