import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Currency Converter =====");
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.println("3. Euro to INR");
        System.out.println("4. INR to Euro");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        double amount, convertedAmount;

        switch (choice) {
            case 1:
                System.out.print("Enter amount in USD: ");
                amount = scanner.nextDouble();
                convertedAmount = usdToInr(amount);
                System.out.printf("Converted amount in INR: ₹%.2f\n", convertedAmount);
                break;

            case 2:
                System.out.print("Enter amount in INR: ");
                amount = scanner.nextDouble();
                convertedAmount = inrToUsd(amount);
                System.out.printf("Converted amount in USD: $%.2f\n", convertedAmount);
                break;

            case 3:
                System.out.print("Enter amount in Euro: ");
                amount = scanner.nextDouble();
                convertedAmount = euroToInr(amount);
                System.out.printf("Converted amount in INR: ₹%.2f\n", convertedAmount);
                break;

            case 4:
                System.out.print("Enter amount in INR: ");
                amount = scanner.nextDouble();
                convertedAmount = inrToEuro(amount);
                System.out.printf("Converted amount in Euro: €%.2f\n", convertedAmount);
                break;

            default:
                System.out.println("Invalid choice. Please select a number between 1 and 4.");
        }

        scanner.close();
    }

    public static double usdToInr(double usd) {
        return usd * 83.47; // Rate as of 01/05/2024
    }

    public static double inrToUsd(double inr) {
        return inr * 0.0119804; // Rate as of 01/05/2024
    }

    public static double euroToInr(double euro) {
        return euro * 89.10; // Rate as of 01/05/2024
    }

    public static double inrToEuro(double inr) {
        return inr * 0.0113; // Rate as of 01/05/2024
    }
}