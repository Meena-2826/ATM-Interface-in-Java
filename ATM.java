import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private HashMap<String, Account> accounts;

    public ATM() {
        accounts = new HashMap<>();
        // Adding a default account for testing
        accounts.put("123456", new Account("123456", "1234", 1000.0));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();

        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        Account account = authenticate(accountNumber, pin);
        if (account != null) {
            System.out.println("Login successful!");
            showMenu(account, scanner);
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }

    private Account authenticate(String accountNumber, String pin) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            if (account.getPin().equals(pin)) {
                return account;
            }
        }
        return null;
    }

    private void showMenu(Account account, Scanner scanner) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    account.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Optional: Add Admin Functionality
    public void addAccount(String accountNumber, String pin, double initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, pin, initialBalance));
        System.out.println("Account added successfully!");
    }
}
