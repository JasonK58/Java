package q2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * <p>
 * This class generates a random number between 1 and 100 (inclusive) allowing
 * the user to guess the number. Upon the correct guess, the following stats
 * will be printed:
 * </p>
 * <ul>
 * <li>Number of guesses it took to get the correct answer.</li>
 * <li>Number of guesses higher and lower than the correct answer.</li>
 * </ul>
 *
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Guess {

    /**
     * <p>Random number generator.</p>
     */
    private static final Random RANDOM = new Random();

    /**
     * <p>User input scanner.</p>
     */
    private static final Scanner SCAN = new Scanner(System.in);

    /**
     * <p>Max value used in random number generator.</p>
     */
    private static final int MAX = 99;
    
    /**
     * <p>Highest number a user can guess.</p>
     */
    private static final int MAX_CHOICE = 100;
    
    /**
     * <p>Random number generated between 1 and 100.</p>
     */
    private static int randomNum;
    
    /**
     * <p>User's guess.</p>
     */
    private static int guess;
    
    /**
     * <p>y or n if user wants to play again or not.<p>
     */
    private static String answer;
    
    /**
     * <p>Counter for amount of guesses.</p>
     */
    private static int guessCount = 1;
    
    /**
     * <p>Counter of guesses that are too low.<p>
     */
    private static int lowGuess; 
    
    /**
     * <p>Counter of guesses that are too high.</p>
     */
    private static int highGuess; 
    
    /**
     * <p>Value to enter if you wish to quit.</p>
     */
    private static int sentinal; 

    /**
     * <p>The main method for the number guessing game.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {

        do {
            randomNum = RANDOM.nextInt(MAX) + 1;
            highGuess = 0;
            lowGuess = 0;
            guessCount = 1;
            guess = -1;
            
            System.out.print("\nNumber Guessing Game\n"
                    + "Press 0 at any time to quit current game.\n"
                    + "Enter a number between 1 and 100: ");

            if (guess != sentinal) {
                
                try {
                    guess = SCAN.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\nYour entry was not a valid integer.");
                }
                
                while (guess != randomNum && guess != sentinal) {
                    
                    if (guess < 0 || guess > MAX_CHOICE) {
                        System.out.println("\nYour guess was not within "
                                + "proper range.");
                        break;
                    }

                    if (guess > randomNum) {
                        System.out.println("\nYour guess was too high.");
                        highGuess++;
                    } else {
                        System.out.println("\nYour guess was too low.");
                        lowGuess++;
                    }

                    System.out.print("Enter a new number between 1 and 100: ");
                    
                    try {
                        guess = SCAN.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\nYour entry was not a valid "
                                + "integer.\n\nYour guess was not within "
                                + "proper range.");
                        break;
                    }

                    guessCount++;
                }
            }

            if (guess == randomNum) {

                System.out.println("\nCongratulations! You correctly guessed "
                        + randomNum + ".\n"
                        + "Stats:\n" + "It took you " + guessCount
                        + " guesses to get the correct answer.\n"
                        + "Your number of low guesses was: " + lowGuess + "\n"
                        + "Your number of high guesses was: " + highGuess);
            }

            System.out.print("\nDo you want to play again?"
                    + "\nPress 'y' to play again or any other key to quit."); 
            SCAN.nextLine();
            answer = SCAN.next();

        } while (answer.toLowerCase().compareTo("y") == 0);

        System.out.println("\nQuestion two was called and ran sucessfully.");
        SCAN.close();
    }
};
