package q3;

/**
 * <p>Class to conduct calculations on test results.</p>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 *
 */
public class Calculations {
	
	/**
     * <p>Number of tests for each student.</p>
     */
    private static final int NUM_TESTS = 3;
    
    /**
     * <p>Gets the total of the three test scores.</p>
     * 
     * @return scoreTotal
     */
    public double getTestScoreTotal(Student student) {
        return student.test1 + student.test2 + student.test3;
    }
    
    /**
     * <p>Calculates the average of the three tests.</p>
     * 
     * @return average average of tests
     */
    public double average(Student student) {
        return (this.getTestScoreTotal(student) / NUM_TESTS);
    }
}
