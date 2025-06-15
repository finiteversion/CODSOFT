import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RangeGenerator generator = new RangeGenerator();
        int totalAttempts = 0;
        int wins = 0;

        while (true) {
            System.out.print("Enter the minimum number: ");
            int min = scanner.nextInt();
            System.out.print("Enter the maximum number: ");
            int max = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            int correctNumber = generator.generate(max, min);
            int attempts = 0;

            while (true) {
                System.out.print("Guess a number between " + min + " and " + max + ": ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess > correctNumber) {
                    System.out.println("It's greater than the correct number.");
                } else if (guess < correctNumber) {
                    System.out.println("It's lower than the correct number.");
                } else {
                    System.out.println("🎉 Correct guess!");
                    wins++;
                    break;
                }
            }

            totalAttempts += attempts;
            System.out.println("Attempts in this round: " + attempts);
            System.out.println("Total wins: " + wins);

            double winRate = (double) wins / totalAttempts * 100;
            System.out.printf("Your current win rate is: %.2f%%\n", winRate);

            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
            scanner.nextLine(); // Clear buffer
        }

        scanner.close();
    }
}

class RangeGenerator {
    public int generate(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}