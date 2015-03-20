package q4;

/**
 * <p>Class that displays messages and information on the console.</p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Console implements Output{
	/**
	 * <p>Displays error message for file not found.</p>
	 */
	@Override
	public void fileNotFound() {
		System.out.println("The file could not be found.\n");
	}
	
	/**
	 * <p>Displays error message when invalid information
	 * is read from the file.</p>
	 */
	@Override
	public void informationError() {
		System.out.println("There is no not enough information to "
                + "add an additional student.\nCheck your file.\n");
	}
	
	/**
	 * <p>Displays error message when invalid test value
	 * is read.</p>
	 */
	@Override
	public void invalidTest() {
		System.out.println("The test result you entered is not valid."
                + " The student has not been added." 
                + "\nCheck your file.\n");
	}
	
	/**
	 * <p>Displays error when an attempt is made to add
	 * an object to a full array.</p>
	 */
	@Override
	public void arraySizeError() {
		System.out.println("The array is not large enough "
                + "to add another student.\n");
	}
	
	/**
	 * <p>Displays the class average as a percent.</p>
	 * 
	 * @param average class average
	 */
	@Override
	public void displayClassAverage(double average) {
		System.out.println("The class average is: " 
				+ Math.round(average) + "%\n");
	}
	
	/**
	 * <p>Displays a list of names of students registered
	 * in the course.</p>
	 * 
	 * @param kids students registered
	 */
	@Override
	public void displayStudents(String kids) {
		System.out.println(kids);
	}
}
