package q2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * <p>Number guessing game. A random number is generated which 
 * the user attempts to guess. The game keeps track of the 
 * following statistics:</p>
 * <ul>
 * <li>Number of total guesses.</li>
 * <li>Number of guesses that were too high.</li>
 * <li>Number of guesses that were too low.</li>
 * </ul>
 * @author Jason Kolenosky
 * @version 1.0
 *
 */
public class Game {
	/**
     * <p>User input scanner.</p>
     */
    public static final Scanner SCAN = new Scanner(System.in);
    
    /**
     * <p>Random number generator.</p>
     */
    private static final Random RANDOM = new Random();

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
    private int randomNum;
    
    /**
     * <p>User's guess.</p>
     */
    private int guess;
    
    /**
     * <p>Counter for amount of guesses.</p>
     */
    private int guessCount = 1;
    
    /**
     * <p>Counter of guesses that are too low.<p>
     */
    private int lowGuess; 
    
    /**
     * <p>Counter of guesses that are too high.</p>
     */
    private int highGuess; 
    
    /**
     * <p>Value to enter if you wish to quit.</p>
     */
    private int sentinal; 
    
    /**
     * <p>Console object for printing messages to 
     * the console.</p>
     */
    private static Console console = new Console();
    
    /**
     * <p>Runs one round of the number guessing game.</p>
     */
	public void playGame() {
		randomNum = RANDOM.nextInt(MAX) + 1;
        highGuess = 0;
        lowGuess = 0;
        guessCount = 1;
        guess = -1;
        
        console.printInstructions();

        if (guess != sentinal) {
            
            try {
            	enterGuess();
            } catch (InputMismatchException e) {
            	console.notValid();
            }
            
            while (guess != randomNum && guess != sentinal) {
            	
                if (guess < 0 || guess > MAX_CHOICE) {
                	console.notInRange();
                    break;
                }

                evaluateGuess();
                
                console.guessPrompt();

                try {
                    enterGuess();
                } catch (InputMismatchException e) {
                    console.notValid();
                    console.notInRange();
                    break;
                }

                guessCount++;
            }
        }

        if (guess == randomNum) {
        	console.winMessage(randomNum, guessCount, lowGuess, highGuess);
        }
	}
	
	/**
	 * <p>Accepts user input as guess.</p>
	 * 
	 * @return guess
	 */
	public int enterGuess() {
        guess = SCAN.nextInt();
		return guess;
	}
	
	/**
	 * <p>Evaluates the guess as being too high or too low.</p>
	 */
	public void evaluateGuess() {
		if (guess > randomNum) {
        	console.tooHigh();
        	highGuess++;
        } else {
        	console.tooLow();
        	lowGuess++;
        }
	}
	
	/**
	 * <p>Method to decide if the user would like to play again.</p>
	 * 
	 * @return user input
	 */
	public String playAgain() {
		console.playAgain();
        SCAN.nextLine();
        return SCAN.next();
	}
}
