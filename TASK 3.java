import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000); // Initial balance ₹100,000
        ATM atmMachine = new ATM(userAccount);
        atmMachine.startTransaction();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
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

    public void showMenu() {
        System.out.println("\n===== Welcome to the ATM =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void startTransaction() {
        int choice;

        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            
            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("Your current balance is: ₹%.2f\n", account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful. New balance: ₹" + account.getBalance());
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdrawalAmount = scanner.nextDouble();
                        if (account.withdraw(withdrawalAmount)) {
                            System.out.println("Withdrawal successful. New balance: ₹" + account.getBalance());
                        } else {
                            System.out.println("Invalid withdrawal amount or insufficient balance.");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}