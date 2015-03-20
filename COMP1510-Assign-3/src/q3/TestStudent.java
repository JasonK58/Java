package q3;

import java.util.InputMismatchException;

/**
 * <p>Driver class that creates student objects. 
 * The following conditions are tested:</p>
 * <ul>
 * <li>Creating a student with no test scores.</li>
 * <li>Creating a student with test scores.</li>
 * <li>Creating a default student with no parameters.</li>
 * <li>Modifying the test scores.</li>
 * </ul>
 *
 * @author Jason Kolenosky
 * @version 2.0
 */
public class TestStudent {
    /**
     * <p>Student1, test1 score.</p>
     */
    private static final double STUDENT1_TEST1 = 80;
    
    /**
     * <p>Student1, test2 score.</p>
     */
    private static final double STUDENT1_TEST2 = 90;
    
    /**
     * <p>Student1, test3 score.</p>
     */
    private static final double STUDENT1_TEST3 = 40;
    
    /**
     * <p>Student2, test1 score.</p>
     */
    private static final double STUDENT2_TEST1 = 75;
    
    /**
     * <p>Student2, test2 score.</p>
     */
    private static final double STUDENT2_TEST2 = 63;
    
    /**
     * <p>Student2, test3 score.</p>
     */
    private static final double STUDENT2_TEST3 = 95;

    /**
     * <p>Student1 new test score.</p>
     */
    private static final double STUDENT1_NEW_TEST1 = 100;
    
    /**
     * <p>Test number 1.</p>
     */
    private static final int TEST_ONE = 1;
    
    /**
     * <p>Test number 2.</p>
     */
    private static final int TEST_TWO = 2;
    
    /**
     * <p>Test number 3.</p>
     */
    private static final int TEST_THREE = 3;
    
    /**
     * <p>Student object for student 1.</p>
     */
    private static Student student1;
    
    /**
     * <p>Student object for student 2.</p>
     */
    private static Student student2;
    
    /**
     * <p>Displays output to the console.</p>
     */
    private static Console console = new Console();
    
    /**
     * <p>Conducts calculations on test scores.</p>
     */
    private static Calculations calculations = new Calculations();
    
    /**
     * <p>The main method for the student constructor testing.</p>
     *
     * @param args unused
     */
    public static void main(String[] args) {
        //Addresses for student1.
        Address student1Home = new Address("111 Here St.", "Surrey", 
                "BC", "H0H 0H0");
        Address student1School = new Address("3700 Willingdon Ave", "Burnaby", 
                "BC", "V5G 3H2");

        //Addresses for student2.
        Address student2Home = new Address("222 There St.", "White Rock", 
                "BC", "A1A 1A1");
        Address student2School = new Address("3700 Willingdon Ave", "Burnaby", 
                "BC", "V5G 3H2");
        
        //Student constructor without test scores.
        student1 = new Student("Jason", "Kolenosky", 
                student1Home, student1School);
        console.constWithoutTestHeader();
        console.displayStudent(student1);
        
        //Student constructor with test scores.
        student1 = new Student("Joe", "Dirt", 
                student1Home, student1School, STUDENT1_TEST1, STUDENT1_TEST2, 
                STUDENT1_TEST3);
        console.constWithTestHeader();
        console.displayStudent(student1);
        console.displayAverage(calculations.average(student1));
        
        //Display and alter a test score.
        try {
        	console.displayTestScore(TEST_ONE, student1);
        } catch (InputMismatchException e) {
            console.invalidTestRetrieve();
        }
        
        try {
            student1.setTestScore(TEST_ONE, STUDENT1_NEW_TEST1); 
        } catch (InputMismatchException e) {
            console.invalidTestAlter();
        }
        
        try {
        	console.displayAlteredTestScore(TEST_ONE, student1);
        } catch (InputMismatchException e) {
        	console.invalidTestRetrieve();
        }
        
        //Default student constructor and setters test.
        student2 = new Student();
        student2.setFirstName("Bob");
        student2.setLastName("Ross");
        student2.setHomeAddress(student2Home);
        student2.setSchoolAddress(student2School);
        student2.setTestScore(TEST_ONE, STUDENT2_TEST1);
        student2.setTestScore(TEST_TWO, STUDENT2_TEST2);
        student2.setTestScore(TEST_THREE, STUDENT2_TEST3);
        console.zeroConstructorHeader();
        console.displayStudent(student2);
        console.displayAverage(calculations.average(student2));
    }
};
