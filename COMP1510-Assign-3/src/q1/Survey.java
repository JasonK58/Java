package q1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>The Survey class does the following functions.</p>
 * <ol>
 * <li>Reads and displays the survey data from an external file.</li>
 * <li>Displays all households with above average income.</li>
 * <li>Displays the percentage of low-income households.</li>
 * </ol>
 * 
 * @author Jason Kolenosky
 * @version 2.0
 */
public class Survey {
    /**
     * <p>Data object to manipulate the information in the file.</p>
     */
	private static Data data = new Data();
	
	/**
	 * <p>Console object for printing to the console.</p>
	 */
	private static Console console = new Console();

    /**
     * <p>Empty scanner object.</p>
     */
    private static Scanner input;
    
    /**
     * <p>The main method that conducts the survey.</p>
     * 
     * @param args unused
     * @throws FileNotFoundException File not found exception
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Create file.
        try {
            input = new Scanner(data.openFile("src", "q1", "survey.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.\n");
        }
        
        //Create households and low income hashtable.
        data.createHouseholds(input);
        data.createHashtable();
        
        //Output data from file.
        console.printHouseholds(Household.numHouseholds);
        
        //Output households who have an above average income.
        console.aboveAverageHouseholds(data);

        //Calculate the amount and percentage of low income households.
        console.lowIncomeHouseholdPercent(data);
        
        input.close();
    }
};
