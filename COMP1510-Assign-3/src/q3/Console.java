package q3;

/**
 * <p>Class to display student information to the console.</p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Console implements Output {
	
	/**
	 * <p>Prints error message for incorrect test number
	 * entered when attempting to retrieve the score.</p>
	 */
	@Override
	public void invalidTestRetrieve() {
		System.out.println("That is not a valid test number."
                + " Could not get test.\n");
	}
	
	/**
	 * <p>Prints error message for incorrect test number
	 * entered when attempting to alter a test score.</p>
	 */
	@Override
	public void invalidTestAlter() {
		System.out.println("That is not a valid test number. "
                + "No changes have been made.\n");
	}
	
	/**
	 * <p>Header for displaying student without test scores.</p>
	 */
	@Override
	public void constWithoutTestHeader() {
		System.out.println("\nStudent constructor without test scores:");
	}
	
	/**
	 * <p>Header for displaying student with test scores.</p>
	 */
	@Override
	public void constWithTestHeader() {
		System.out.println("\nStudent constructor with test scores:");
	}
	
	/**
	 * <p>Displays the specified test score for the 
	 * specified student.</p>
	 * 
	 * @param test test number
	 * @param student specified student
	 */
	@Override
	public void displayTestScore(int test, Student student) {
		System.out.println("The test " + test + " score for student1 is: " 
	            + student.getTestScore(test) + "%\n");
	}
	
	/**
	 * <p>Displays altered test score for the
	 * specified student.</p>
	 * 
	 * @param test test number
	 * @param student specified student
	 */
	@Override
	public void displayAlteredTestScore(int test, Student student) {
		System.out.println("The new test " + test + " score for student1 is: " 
                + student.getTestScore(test) + "%\n");
	}
	
	/**
	 * <p>Header for displaying student from zero parameter
	 * constructor.</p>
	 */
	@Override
	public void zeroConstructorHeader() {
		System.out.println("Zero paramater student constructor "
                + "using setters:");
	}
	
	/**
	 * <p>Displays specified student information.</p>
	 * 
	 * @param student student to display
	 */
	@Override
	public void displayStudent(Student student) {
		System.out.println(student.toString());
	}
	
	/**
	 * <p>Displays the average of the three tests.</p>
	 * 
	 * @param calculation calculated average
	 */
	@Override
	public void displayAverage(double calculation) {
		System.out.println("Average of test scores: " 
				+ Math.round(calculation) + "%\n");
	}
}
