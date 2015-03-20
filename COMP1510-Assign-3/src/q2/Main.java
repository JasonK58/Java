package q2;


/**
 * <p>The driver class that runs the number guessing game.</p>
 *
 * @author Jason Kolenosky
 * @version 2.0
 */
public class Main {
    /**
     * <p>Game object to play the game.</p>
     */
    private static Game game = new Game();

    /**
     * <p>The main method for the number guessing game.</p>
     *
     * @param args unused
     */
    public static void main(String[] args) {
    	
        do {
            game.playGame();
        } while (game.playAgain().toLowerCase().compareTo("y") == 0);
    }
};
