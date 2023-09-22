import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int lowerRange = 1;
            int upperRange = 100;
            int numberToGuess = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;
            int maxAttempts = 7; // You can adjust this value to limit the number of attempts.

            System.out.println("I'm thinking of a number between " + lowerRange + " and " + upperRange + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + (attempts + 1) + " attempts.");
                    score++;
                    break;
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Your final score is: " + score + " rounds won.");
        scanner.close();
    }
}
