package q1;

import java.text.NumberFormat;

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
 * @version 1.0
 *
 */
public class Household {
    /**
     * <p>Three member household.</p>
     */
    private static final int CASE_3 = 3;
    
    /**
     * <p>Four member household.</p>
     */
    private static final int CASE_4 = 4;
    
    /**
     * <p>Five member household.</p>
     */
    private static final int CASE_5 = 5;
    
    /**
     * <p>Six member household.</p>
     */
    private static final int CASE_6 = 6;
    
    /**
     * <p>Seven member household.</p>
     */
    private static final int CASE_7 = 7;
    
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
    private int numHouseholds;
    
    /**
     * <p>Identifier if a household is low-income or not.</p>
     */
    private boolean low;
    
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
     * @param id Household ID number.
     * @param income Household income.
     * @param members Number of members in household.
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
     * <p>String description of household object.</p>
     * 
     * @return String
     */
    public String toString() {
        String string = String.format("%4s %11s %5s", this.getId(),
                this.getFormatIncome(), this.getMembers());
        
        return string;
    }
    
    /**
     * <p>Identifies if a household is low-income.</p>
     * 
     * @return low
     */
    public boolean lowIncome() {
        switch (this.getMembers()) {
        case 1:
            if (income <= CASE_1_INCOME) {
                low = true;
            }
            break;
        case 2:
            if (income <= CASE_2_INCOME) {
                low = true;
            }
            break;
        case CASE_3:
            if (income <= CASE_3_INCOME) {
                low = true;
            }
            break;
        case CASE_4:
            if (income <= CASE_4_INCOME) {
                low = true;
            }
            break;
        case CASE_5:
            if (income <= CASE_5_INCOME) {
                low = true;
            }
            break;
        case CASE_6:
            if (income <= CASE_6_INCOME) {
                low = true;
            }
            break;
        case CASE_7:
            if (income <= CASE_7_INCOME) {
                low = true;
            }
            break;
        default:
            difference = members - CASE_7;
            incomeCap = (difference * INCOME_PER_PERSON) + CASE_7_INCOME;
            if (income <= incomeCap) {
                low = true;
            }    
        }
        return low;
    }
}
