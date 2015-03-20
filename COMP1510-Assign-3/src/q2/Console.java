package q2;

/**
 * <p>Class that displays messages to the console.</p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Console implements Output {
	/**
	 * <p>Displays the game title and instructions.</p>
	 */
	@Override
	public void printInstructions() {
		System.out.print("\nNumber Guessing Game\n"
                + "Press 0 at any time to quit current game.\n"
                + "Enter a number between 1 and 100: ");
	}
	
	/**
	 * <p>Displays a message if the entered value is not an integer.</p>
	 */
	@Override
	public void notValid() {
		System.out.println("\nYour entry was not a valid integer.");
	}
	
	/**
	 * <p>Displays a message if the value entered is not within
	 * the legal range.</p>
	 */
	@Override
	public void notInRange() {
		System.out.println("\nYour guess was not within "
                + "proper range.");
	}
	
	/**
	 * <p>Displays a message if the guess is too high.</p>
	 */
	@Override
	public void tooHigh() {
		System.out.println("\nYour guess was too high.");
	}
	
	/**
	 * <p>Displays a message if the guess is too low.</p>
	 */
	@Override
	public void tooLow() {
		System.out.println("\nYour guess was too low.");
	}
	
	/**
	 * <p>Prompts the user to enter a guess.</p>
	 */
	@Override
	public void guessPrompt() {
		System.out.print("Enter a new number between 1 and 100: ");
	}
	
	/**
	 * <p>Displays a winning message as well as game statistics.</p>
	 */
	@Override
	public void winMessage(int correctNumber, int count, int low, int high) {
		System.out.println("\nCongratulations! You correctly guessed "
                + correctNumber + ".\n"
                + "Stats:\n" + "It took you " + count
                + " guesses to get the correct answer.\n"
                + "Your number of low guesses was: " + low
                + "\nYour number of high guesses was: " + high);
	}
	
	/**
	 * <p>Prompts the user to play again or quit.</p>
	 */
	@Override
	public void playAgain() {
		System.out.print("\nDo you want to play again?"
                + "\nPress 'y' to play again or any other key to quit."); 
	}
}
