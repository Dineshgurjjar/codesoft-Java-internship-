// package java;
import java.util.*;

public class GuessingNumberGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        int highScore = 0;

        while (true) {
            System.out.println("Welcome to the Guessing Number Game!");
            System.out.println("Choose a difficulty level:");
            System.out.println("1: Easy (1-50, 10 attempts)");
            System.out.println("2: Medium (1-100, 7 attempts)");
            System.out.println("3: Hard (1-200, 5 attempts)");
            System.out.print("Enter your choice (1/2/3): ");

            int level = getValidLevel(scanner);

            int maxNumber = 100;
            int attempts = 7;

            switch (level) {
                case 1:
                    maxNumber = 50;
                    attempts = 10;
                    break;
                case 2:
                    maxNumber = 100;
                    attempts = 7;
                    break;
                case 3:
                    maxNumber = 200;
                    attempts = 5;
                    break;
            }

            int numberToGuess = random.nextInt(maxNumber) + 1;
            boolean hasGuessedCorrectly = false;
            int attemptsLeft = attempts;

            System.out.println("I have selected a number between 1 and " + maxNumber + ". Can you guess it?");
            System.out.println("You have " + attemptsLeft + " attempts to guess the number.");

            while (attemptsLeft > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    int score = attemptsLeft;  
                    if (score > highScore) {
                        highScore = score;
                    }
                    System.out.println("You scored " + score + " points!");
                } else if (userGuess < numberToGuess) {
                    System.out.println();
                    System.out.println("Too low. Try again.");
                    System.out.println("Hint: The number is " + (numberToGuess % 2 == 0 ? "even" : "odd") + ".");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("Too high. Try again.");
                    System.out.println("Hint: The number is " + (numberToGuess % 2 == 0 ? "even" : "odd") + ".");
                    System.out.println();
                }

                attemptsLeft--;
                if (attemptsLeft > 0 && !hasGuessedCorrectly) {
                    System.out.println();
                    System.out.println("You have " + attemptsLeft + " attempts left.");
                } else if (attemptsLeft == 0 && !hasGuessedCorrectly) {
                    System.out.println();
                    System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
                }
            }

            totalRounds++;
            System.out.println("Total rounds played: " + totalRounds);
            System.out.println("Rounds won: " + roundsWon);
            System.out.println("Success rate: " + (roundsWon * 100.0 / totalRounds) + "%");
            System.out.println("Current high score: " + highScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing! Your final statistics:");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Success rate: " + (roundsWon * 100.0 / totalRounds) + "%");
        System.out.println("High score: " + highScore);

        scanner.close();
    }

    private static int getValidLevel(Scanner scanner) {
        int level;
        while (true) {
            try {
                level = Integer.parseInt(scanner.next());
                if (level >= 1 && level <= 3) {
                    break;
                } else {
                    System.out.print("Invalid choice. Enter 1, 2, or 3: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter 1, 2, or 3: ");
            }
        }
        return level;
    }
}
