import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7; 
        int score = 0; 
        boolean playAgain = true;
        
        System.out.println("🎯 Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;
            
            System.out.println("\nI have selected a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");
            
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                
                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    
                    if (guess < lowerBound || guess > upperBound) {
                        System.out.println("⚠️ Please enter a number between " + lowerBound + " and " + upperBound + ".");
                        continue;
                    }

                    if (guess < secretNumber) {
                        System.out.println("📉 Too low! Try again.");
                    } else if (guess > secretNumber) {
                        System.out.println("📈 Too high! Try again.");
                    } else {
                        System.out.println("🎉 Congratulations! You guessed it in " + (maxAttempts - attemptsLeft + 1) + " attempts.");
                        score++;
                        guessedCorrectly = true;
                        break;
                    }
                    
                    attemptsLeft--;
                } else {
                    System.out.println("⚠️ Invalid input! Please enter a valid number.");
                    scanner.next(); 
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("😞 Out of attempts! The correct number was " + secretNumber + ".");
            }
            
            System.out.println("🏆 Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }
        
        System.out.println("🎮 Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}
