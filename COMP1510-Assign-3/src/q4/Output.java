package q4;

/**
 * <p>Interface for displaying information.</p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public interface Output {
	/**
	 * <p>Displays error message for file not found.</p>
	 */
	public void fileNotFound();
	
	/**
	 * <p>Displays error message when invalid information
	 * is read from the file.</p>
	 */
	public void informationError();
	
	/**
	 * <p>Displays error message when invalid test value
	 * is read.</p>
	 */
	public void invalidTest();
	
	/**
	 * <p>Displays error when an attempt is made to add
	 * an object to a full array.</p>
	 */
	public void arraySizeError();
	
	/**
	 * <p>Displays the class average as a percent.</p>
	 * 
	 * @param average class average
	 */
	public void displayClassAverage(double average);
	
	/**
	 * <p>Displays a list of names of students registered
	 * in the course.</p>
	 * 
	 * @param kids students registered
	 */
	public void displayStudents(String kids);
}
