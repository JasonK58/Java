package q3;

import java.util.InputMismatchException;


/**
 * <p>This class creates student objects. 
 * The following constructors are used:</p>
 *<ul>
 *<li>When test scores are entered or not entered</li>
 *<li>Default constructor with no parameters.</li>
 *</ul>
 *
 *<p>The class also uses the following methods:</p>
 *<ul>
 *<li>Getters and setters for test scores.</li>
 *<li>Average calculator.</li>
 *<li>Student descriptor.</li>
 *</ul>
 *
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Student {

    /**
     * <p>Test number 3.</p>
     */
    private static final int TEST3 = 3;
    
    /**
     * <p>Number of tests for each student.</p>
     */
    private static final int NUM_TESTS = 3;
    
    /** 
     * <p>First name of this student.</p>
     */
    private String firstName;

    /** 
     * <p>Last name of this student.</p>
     */
    private String lastName;

    /** 
     * <p>Home address of this student.</p>
     */
    private Address homeAddress;

    /** 
     * <p>School address of this student.</p>
     */
    private Address schoolAddress;

    /**
     * <p>Test one score.</p>
     */
    private double test1;
    
    /**
     * <p>Test two score.</p>
     */
    private double test2;
    
    /**
     * <p>Test three score.</p>
     */
    private double test3;
    
    /**
     * <p>Average of the three test scores.</p>
     */
    private double average;
    
    /**
     * <p>Student descriptor.</p>
     */
    private String result;
    
    /**
     * <p>Total of the test scores added together.</p>
     */
    private double scoreTotal;

    /**
    * <p>Constructor: Sets up this student with the specified values.</p>
    * 
    * @param first The first name of the student
    * @param last The last name of the student
    * @param home The home address of the student
    * @param school The school address of the student
    */
    public Student(String first, String last, Address home, Address school) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
    }
    
    /**
     * <p>Student constructor with three test scores.</p>
     * 
     * @param first first name
     * @param last last name
     * @param home home address
     * @param school school address
     * @param t1 test 1 score
     * @param t2 test 2 score
     * @param t3 test 3 score
     */
    public Student(String first, String last, Address home, Address school,
            double t1, double t2, double t3) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        test1 = t1;
        test2 = t2;
        test3 = t3;
    }
    
    /**
     * <p>Zero parameter student constructor.</p>
     */
    public Student() {
        
    }
    
    /**
     * <p>Gets the name of the student.</p>
     * 
     * @return name string
     */
    public String getName() {
        return lastName + ", " + firstName;
    }
    
    /**
     * <p>First name setter.</p>
     * 
     * @param first First name.
     */
    public void setFirstName(String first) {
        this.firstName = first; 
    }
    
    /**
     * <p>Last name setter.</p>
     * 
     * @param last Last name.
     */
    public void setLastName(String last) {
        this.lastName = last;
    }
    
    /**
     * <p>Home address setter.</p>
     * 
     * @param home Home address.
     */
    public void setHomeAddress(Address home) {
        this.homeAddress = home;
    }
    
    /**
     * <p>School address setter.</p>
     * 
     * @param school School address.
     */
    public void setSchoolAddress(Address school) {
        this.schoolAddress = school;
    }
    
    /**
     * <p>Test score setter.</p>
     * @param test test number
     * @param testScore test score
     */
    public void setTestScore(int test, double testScore) {
        switch (test) {
        case 1:
            this.test1 = testScore;
            break;
        case 2:
            this.test2 = testScore;
            break;
        case TEST3:
            this.test3 = testScore;
            break;
        default:
            throw new InputMismatchException();
        }
    }
    
    /**
     * <p>Getter for test scores.</p>
     * 
     * @param test test number
     * @return score
     */
    public double getTestScore(int test) {
        switch (test) {
        case 1:
            return this.test1;
        case 2:
            return this.test2;
        case TEST3:
            return this.test3;
        default:
            throw new InputMismatchException();
        }
    }
    
    /**
     * <p>Gets the total of the three test scores.</p>
     * 
     * @return scoreTotal
     */
    public double getTestScoreTotal() {
        scoreTotal = this.test1 + this.test2 + this.test3;
        return scoreTotal;
    }
    
    /**
     * <p>Calculates the average of the three tests.</p>
     * 
     * @return average
     */
    public double average() {
        average = (this.getTestScoreTotal() / NUM_TESTS);
        return average;
    }

    /**
    * <p>Returns a string description of this Student object.</p>
    * 
    * @return formatted name and addresses of student
    */
    public String toString() {
        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress + "\n";
        result += "Test score 1: " + getTestScore(1) + "\n";
        result += "Test score 2: " + getTestScore(2) + "\n";
        result += "Test score 3: " + getTestScore(TEST3) + "\n";
        result += "Average of test scores: " + Math.round(average()) + "%\n";

        return result;
    }
}
