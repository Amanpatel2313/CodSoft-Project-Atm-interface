import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Your balance is: Rupees " + balance);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit : Rupees");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Please enter a valid amount.");
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: Rupees");
        double amount = scanner.nextDouble();
        if (amount > 0 && account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid amount or insufficient fund. Please try again.");
        }
    }

    public void close() {
        scanner.close();
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
        atm.close();
    }
}
