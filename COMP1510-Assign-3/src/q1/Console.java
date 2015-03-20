package q1;

/**
 * <p>This class uses the console to display information.<p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 *
 */
public class Console implements Output {
	/**
	 * <p>Displays error message.</p>
	 */
	 @Override
	public void displayError() {
		System.out.println("There was either not enough information to "
				+ "enter another\nhousehold or the information was not "
				+ "an integer.\nCheck your file.\n");
	}
	
	/**
	 * <p>Prints the household information to the console.</p>
	 */
	@Override
	public void printHouseholds(int householdTotal) {
		System.out.println("Survey Results for " + householdTotal + " Households");
		System.out.printf("%s%13s%13s\n", "ID", "Income", "Members");
		for (Object object : Data.houseArray) {
			System.out.println(object.toString());
		}
	}
	
	/**
	 * <p>Prints the households with above average income to the console.</p>
	 */
	@Override
	public void aboveAverageHouseholds(Data object) {
        System.out.println("\nHouseholds With Above Average Income\nID\t Income");
        System.out.println(object.aboveAverage());
	}
	
	/**
	 * <p>Prints the percentage of low income households to the console.</p>
	 */
	@Override
	public void lowIncomeHouseholdPercent(Data object) {
		System.out.println("Household Percentage With Low Incomes: " 
                + Math.round(object.percentLowIncome(object)) + "%");
	}
}
