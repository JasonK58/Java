package q1;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <p>The data class manipulates the information pulled from a file
 * into an ArrayList. The following methods are included:</p>
 * <ul>
 * <li>open a file.</li>
 * <li>Create household objects to be stored in an ArrayList.</li>
 * <li>Create a hashtable that holds low income thresholds.</li>
 * </li>Calculate the total income of all the households.</li>
 * </li>Calculate the average income of all the households.</li>
 * </li>Display the households with above average income.</li>
 * </li>Calculate the number of households with low income.</li>
 * </li>Calculate the percent of households with low income.</li>
 * </ul>
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Data {
	/**
	 * <p>Multiplier to turn a decimal into a percent.</p>
	 */
	private static final int MULTIPLIER = 100;
	
	/**
     * <p>One member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_1 = 1;
    
    /**
     * <p>Two member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_2 = 2;
    
    /**
     * <p>Three member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_3 = 3;
    
    /**
     * <p>Four member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_4 = 4;
    
    /**
     * <p>Five member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_5 = 5;
    
    /**
     * <p>Six member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_6 = 6;
    
    /**
     * <p>Seven member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_7 = 7;
    
    /**
     * <p>One person household low-income cut-off.</p>
     */
    private static final int CASE_1_INCOME = 22229;
    
    /**
     * <p>Two person household low-income cut-off.</p>
     */
    private static final int CASE_2_INCOME = 27674;
    
    /**
     * <p>Three person household low-income cut-off.</p>
     */
    private static final int CASE_3_INCOME = 34022;
    
    /**
     * <p>Four person household low-income cut-off.</p>
     */
    private static final int CASE_4_INCOME = 41307;
    
    /**
     * <p>Five person household low-income cut-off.</p>
     */
    private static final int CASE_5_INCOME = 46850;
    
    /**
     * <p>Six person household low-income cut-off.</p>
     */
    private static final int CASE_6_INCOME = 52838;
    
    /**
     * <p>Seven person household low-income cut-off.</p>
     */
    private static final int CASE_7_INCOME = 58827;

    /**
     * <p>Hashtable for storing low income thresholds.</p>
     */
    private Hashtable<Integer, Integer> incomeCutoff;
    
	/**
	 * <p>
	 * ArrayList holding the household information.
	 * </p>
	 */
	static ArrayList<Household> houseArray = new ArrayList<Household>();
	
	/**
	 * <p>Console object.</p>
	 */
	static Console console = new Console();
	
	/**
	 * <p>Opens a file from a sub-folder inside a root folder.</p>
	 * 
	 * @param root root folder
	 * @param sub sub folder
	 * @param file file
	 * @return file surveyFile
	 */
	public File openFile(String root, String sub, String file) {
		File surveyFile = new File(root + File.separator + sub + File.separator
				+ file);
		return surveyFile;
	}
	
	/**
	 * <p>Creates household objects from a file.</p>
	 * 
	 * @param file file to be read
	 */
	public void createHouseholds(Scanner file) {

		try {
			while (file.hasNext()) {
				Household object = new Household(file.nextInt(),
						file.nextInt(), file.nextInt());
				houseArray.add(object);
			}
		} catch (NoSuchElementException e) {
			console.displayError();
		}
		
	}
	
	/**
	 * <p>Creates a Hashtable of income thresholds.</p>
	 */
    void createHashtable() {
    	incomeCutoff = new Hashtable<Integer, Integer>();
    	
    	incomeCutoff.put(HOUSEHOLD_MEMBERS_1, CASE_1_INCOME);
    	incomeCutoff.put(HOUSEHOLD_MEMBERS_2, CASE_2_INCOME);
    	incomeCutoff.put(HOUSEHOLD_MEMBERS_3, CASE_3_INCOME);
    	incomeCutoff.put(HOUSEHOLD_MEMBERS_4, CASE_4_INCOME);
    	incomeCutoff.put(HOUSEHOLD_MEMBERS_5, CASE_5_INCOME);
    	incomeCutoff.put(HOUSEHOLD_MEMBERS_6, CASE_6_INCOME);
    	incomeCutoff.put(HOUSEHOLD_MEMBERS_7, CASE_7_INCOME);
    }
	
	/**
	 * <p>Calculate the total income of the households.</p>
	 * 
	 * @return totalIncome
	 */
	public double totalIncome() {
		double totalIncome = 0;
		
		for (Household object : houseArray) {
            totalIncome += object.getIncome();
        }
		return totalIncome;
		
	}
	
	/**
	 * <p>Calculates the average income of the total households.</p>
	 * 
	 * @return average income
	 */
	public double average() {
		double totalIncome = totalIncome();
		double size = houseArray.size();
		return (totalIncome / size);
	}
	
	/**
	 * <p>Displays the households with above average income.</p>
	 * 
	 * @return households 
	 */
	public String aboveAverage() {
		String households = "";
		double average = average();
		
		for (Household object : houseArray) {
            if (object.getIncome() >= average) {
                households += String.format("%4s %11s", 
                        object.getId(), object.getFormatIncome()) + "\n";
            }
        }
		
		return households;
	}
	
	/**
	 * <p>Calculates the number of low income households.</p>
	 * 
	 * @return lowIncomeHouseholds
	 */
	public int numLowHouseholds() {
		int lowIncomeHouseholds = 0;
		
		for (Household object : houseArray) {
            if (object.isLowIncome(incomeCutoff)) {
            	lowIncomeHouseholds++;
            }
        }
		return lowIncomeHouseholds;
	}
	
	/**
	 * <p>Calculates the percentage of low income houses.</p>
	 * 
	 * @param object
	 * @return percentage
	 */
	public double percentLowIncome(Data object) {
		int numLowIncome = object.numLowHouseholds();
		int totalHouseholds = houseArray.size();
		
		return (((double) numLowIncome / totalHouseholds) * MULTIPLIER);
	}
}
