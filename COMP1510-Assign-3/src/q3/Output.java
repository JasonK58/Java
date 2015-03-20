package q3;

/**
 * <p>Interface to display information to the user.</p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public interface Output {
	/**
	 * <p>Prints error message for incorrect test number
	 * entered when attempting to retrieve the score.</p>
	 */
	public void invalidTestRetrieve();
	
	/**
	 * <p>Prints error message for incorrect test number
	 * entered when attempting to alter a test score.</p>
	 */
	public void invalidTestAlter();
	
	/**
	 * <p>Header for displaying student without test scores.</p>
	 */
	public void constWithoutTestHeader();
	
	/**
	 * <p>Header for displaying student with test scores.</p>
	 */
	public void constWithTestHeader();
	
	/**
	 * <p>Displays the specified test score for the 
	 * specified student.</p>
	 * 
	 * @param test test number
	 * @param student specified student
	 */
	public void displayTestScore(int test, Student student);
	
	/**
	 * <p>Displays altered test score for the
	 * specified student.</p>
	 * 
	 * @param test test number
	 * @param student specified student
	 */
	public void displayAlteredTestScore(int test, Student student);
	
	/**
	 * <p>Header for displaying student from zero parameter
	 * constructor.</p>
	 */
	public void zeroConstructorHeader();
	
	/**
	 * <p>Displays specified student information.</p>
	 * 
	 * @param student student to display
	 */
	public void displayStudent(Student student);
	
	/**
	 * <p>Displays the average of the three tests.</p>
	 * 
	 * @param calculation calculated average
	 */
	void displayAverage(double calculation);
}
