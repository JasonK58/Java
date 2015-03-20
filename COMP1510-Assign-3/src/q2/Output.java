package q2;

/**
 * <p>Interface for game output messages to be displayed.</p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public interface Output {
	
	/**
	 * <p>Displays the instructions for the game.</p>
	 */
	public void printInstructions();
	
	/**
	 * <p>Displays an error message for an invalid choice.</p>
	 */
	public void notValid();
	
	/**
	 * <p>Displays an error message for entering a value
	 * outside the legal range.</p>
	 */
	public void notInRange();
	
	/**
	 * <p>Prints an error message for guessing too high.</p>
	 */
	public void tooHigh();
	
	/**
	 * <p>Prints an error message for guessing too low.</p>
	 */
	public void tooLow();
	
	/**
	 * </p>Prompt user to enter a guessed number.</p>
	 */
	public void guessPrompt();
	
	/**
	 * <p>Displays a winning message and statistics.</p>
	 */
	public void winMessage(int correctNumber, int count, int low, int high);
	
	/**
	 * <p>Asks the user if they want to play again.</p>
	 */
	public void playAgain();
}
