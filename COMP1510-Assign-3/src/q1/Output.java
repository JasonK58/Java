package q1;

/**
 * <p>This interface is for methods needed to display information.<p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 *
 */
public interface Output {
	/**
	 * <p>Displays error message.</p>
	 */
	public void displayError();
	
	/**
	 * <p>Displays the number of households and their information.</p>
	 * 
	 * @param householdTotal total number of households
	 */
	public void printHouseholds(int householdTotal);
	
	/**
	 * </p>Displays the households with above average income.</p>
	 * 
	 * @param object data object
	 */
	public void aboveAverageHouseholds(Data object);
	
	/**
	 * </p>Displays the percentage of low income households.</p>
	 * 
	 * @param object data object
	 */
	public void lowIncomeHouseholdPercent(Data object);
}
