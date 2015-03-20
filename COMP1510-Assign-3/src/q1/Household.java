package q1;

import java.text.NumberFormat;
import java.util.Hashtable;

/**
 * <p>This class creates a household object. Each household uses
 * the following parameters:</p>
 * <ul>
 * <li>id - household ID number</li>
 * <li>income - household income</li>
 * <li>members - Number of people in the household</li>
 * </ul>
 * 
 * <p>The class contains the following methods:</p>
 * <ul>
 * <li>Getters for id, income, formatted income, members, and
 * number of households.</li>
 * <li>Description of the household.</li>
 * <li>Identifier if a household is considered low-income.</li>
 * </ul>
 * 
 * @author Jason Kolenosky
 * @version 2.0
 *
 */
public class Household {
    /**
     * <p>Seven member household.</p>
     */
    private static final int HOUSEHOLD_MEMBERS_7 = 7;
    
    /**
     * <p>Seven person household low-income cut-off.</p>
     */
    private static final int CASE_7_INCOME = 58827;
    
    /**
     * <p>In households with more than seven members, low-income
     * is $58,827 plus $5,989 per additional person.</p>
     */
    private static final int INCOME_PER_PERSON = 5989;
    
    /**
     * <p>Household ID number.</p>
     */
    private int id;
    
    /**
     * <p>Household income.</p>
     */
    private int income;
    
    /**
     * <p>Number of household members.</p>
     */
    private int members;
    
    /**
     * <p>Number of household objects.</p>
     */
    static int numHouseholds;

    /**
     * <p>Number of household members above 7.</p>
     */
    private int difference;
    
    /**
     * <p>Cut-off to be defined as low-income.</p>
     */
    private int incomeCap;

    /**
     * <p>Household constructor.</p>
     * 
     * @param id Household ID number
     * @param income Household income
     * @param members Number of members in household
     */
    public Household(int id, int income, int members) {
        this.id = id;
        this.income = income;
        this.members = members;
        numHouseholds++;
    }
    
    /**
     * <p>Gets household ID.</p>
     * 
     * @return id
     */
    public int getId() {
        return id;
    }
    
    /**
     * <p>Gets household income.</p>
     * 
     * @return income
     */
    public int getIncome() {
        return income;
    }
    
    /**
     * <p>Gets household income formatted as a currency instance.</p>
     * 
     * @return income
     */
    public String getFormatIncome() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMinimumFractionDigits(0);
        return format.format(this.income);
    }
    
    /**
     * <p>Gets number of household members.</p>
     * 
     * @return members
     */
    public int getMembers() {
        return members;
    }
    
    /**
     * <p>Gets the total number of households.</p>
     * 
     * @return numHouseholds
     */
    public int getNumHouseholds() {
        return numHouseholds;
    }

    /**
     * <p>Determines if a household is deemed low-income.</p>
     * 
     * @param incomeCutoff cutoff for low income status
     * @return boolean is low income
     */
    public boolean isLowIncome(Hashtable<Integer, Integer> incomeCutoff) {
    	if (this.getMembers() <= HOUSEHOLD_MEMBERS_7)
    		return income < incomeCutoff.get(this.getMembers());
    	else {
    		difference = members - HOUSEHOLD_MEMBERS_7;
            incomeCap = (difference * INCOME_PER_PERSON) + CASE_7_INCOME;
            return income < incomeCap;
    	}
    }
    
    /**
     * <p>String description of household object.</p>
     * 
     * @return String
     */
    public String toString() {
        String string = String.format("%4s %11s %5s", this.getId(),
                this.getFormatIncome(), this.getMembers());
        
        return string;
    }
}
