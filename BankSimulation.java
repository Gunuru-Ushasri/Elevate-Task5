import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class
class Account {
    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;
    protected List<String> transactions;

    public Account(String name, String number, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = number;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account opened with balance: ₹" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited ₹" + amount);
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactions.add("Withdrawn ₹" + amount);
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showBalance() {
        System.out.println("\nAccount Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }
}

// Derived class
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String name, String number, double balance, double interestRate) {
        super(name, number, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 500) {
            balance -= amount;
            transactions.add("Withdrawn ₹" + amount + " (Savings)");
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Maintain min balance of ₹500.");
        }
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        transactions.add("Interest Applied: ₹" + interest);
        System.out.println("Interest Applied: ₹" + interest);
    }
}

// Main class
public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get account details
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        System.out.print("Enter Interest Rate (%): ");
        double interestRate = sc.nextDouble();

        SavingsAccount account = new SavingsAccount(name, accNo, initialBalance, interestRate);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Apply Interest");
            System.out.println("4. Show Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depAmt = sc.nextDouble();
                    account.deposit(depAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withAmt = sc.nextDouble();
                    account.withdraw(withAmt);
                    break;
                case 3:
                    account.applyInterest();
                    break;
                case 4:
                    account.showBalance();
                    break;
                case 5:
                    account.showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using our banking system!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
