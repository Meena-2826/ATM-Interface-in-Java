import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount + " | New Balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; // Insufficient funds
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount + " | New Balance: " + balance);
        return true;
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
