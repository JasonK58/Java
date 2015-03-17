package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <p>The Survey class does the following functions.</p>
 * <ol>
 * <li>Reads and prints the survey data from an external file.</li>
 * <li>Prints all households with above average income.</li>
 * <li>Prints the percentage of low-income households.</li>
 * </ol>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Survey {
    
    /**
     * <p>Multiplier to create a percentage.</p>
     */
    private static final int MULTIPLIER = 100;
    
    /**
     * <p>Survey data file.</p>
     */
    private static final File FILE = new File("src" + File.separator + "q1" 
            + File.separator 
            + "survey.txt");
    
    /**
     * <p>Number of households in the survey.</p>
     */
    private static int counter;
    
    /**
     * <p>Income of all households added together.</p>
     */
    private static double totalIncome;
    
    /**
     * <p>Number of households that have low income.</p>
     */
    private static int lowIncome;
    
    /**
     * <p>ArrayList holding the household information.</p>
     */
    private static ArrayList<Household> houseArray = new ArrayList<Household>();
    
    /**
     * <p>Empty scanner object.</p>
     */
    private static Scanner input;
    /**
     * <p>The main method that applies the survey data.</p>
     * 
     * @param args unused
     * @throws FileNotFoundException File not found exception
     */
    public static void main(String[] args) throws FileNotFoundException {

        double average; //Average income of all households.
        double percentage; //Percentage of low-income households.
        
        try {
            input = new Scanner(FILE);
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.\n");
        }
        
        try {
            while (input.hasNext()) {
                Household object = new Household(input.nextInt(), 
                        input.nextInt(), input.nextInt());
                houseArray.add(object);
                counter++;
            }
        } catch (NoSuchElementException e) {
            System.out.println("There was either not enough information to "
                    + "enter another\nhousehold or the information was not "
                    + "an integer.\nCheck your file.\n");
        }
        
        System.out.println("Survey Results for " + counter + " Households");
        System.out.println("ID\t Income\t     Members");
        
        //Calculate the total income of the households and the income average.
        for (Household object : houseArray) {
            System.out.println(object);
            totalIncome += object.getIncome();
        }
        average = totalIncome / houseArray.size();
        System.out.println();
        System.out.println("Households With Above Average Income");
        System.out.println("ID\t Income");
        for (Household object : houseArray) {
            if (object.getIncome() >= average) {
                System.out.println(String.format("%4s %11s", 
                        object.getId(), object.getFormatIncome()));
            }
        }
        
        //Calculate the amount and percentage of low income households.
        int households = houseArray.size();
        for (Household object : houseArray) {
            if (object.lowIncome()) {
                lowIncome += 1;
            }
        }
        percentage = ((double) lowIncome / (double) households) * MULTIPLIER;
        System.out.println("\nHousehold Percentage With Low Incomes: " 
                            + Math.round(percentage) + "%");
        
        System.out.println("\nQuestion one was called and ran sucessfully.");
        input.close();
    }
};
