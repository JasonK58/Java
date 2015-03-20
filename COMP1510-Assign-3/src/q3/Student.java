package q3;

import java.util.InputMismatchException;


/**
 * <p>This class creates student objects. 
 * The following constructors are used:</p>
 *<ul>
 *<li>When test scores are entered or not entered.</li>
 *<li>Default constructor with no parameters.</li>
 *</ul>
 *
 *<p>The class also uses the following methods:</p>
 *<ul>
 *<li>Getters and setters for test scores.</li>
 *<li>Student descriptor.</li>
 *</ul>
 *
 * @author Jason Kolenosky
 * @version 2.0
 */
public class Student {

	/**
     * <p>Test number 1.</p>
     */
    private static final int TEST_NUM_1 = 1;
    
	/**
     * <p>Test number 2.</p>
     */
    private static final int TEST_NUM_2 = 2;
    
    /**
     * <p>Test number 3.</p>
     */
    private static final int TEST_NUM_3 = 3;

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
    double test1;
    
    /**
     * <p>Test two score.</p>
     */
    double test2;
    
    /**
     * <p>Test three score.</p>
     */
    double test3;

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
     * <p>Test score setter.
     * Note: Since it's a small switch it should be OK.</p>
     * 
     * @param test test number
     * @param testScore test score
     */
    public void setTestScore(int test, double testScore) {
        switch (test) {
        case TEST_NUM_1:
            this.test1 = testScore;
            break;
        case TEST_NUM_2:
            this.test2 = testScore;
            break;
        case TEST_NUM_3:
            this.test3 = testScore;
            break;
        default:
            throw new InputMismatchException();
        }
    }
    
    /**
     * <p>Getter for test scores.
     * Note: Since it's a small switch it should be OK.</p>
     * 
     * @param test test number
     * @return score
     */
    public double getTestScore(int test) {
        switch (test) {
        case TEST_NUM_1:
            return this.test1;
        case TEST_NUM_2:
            return this.test2;
        case TEST_NUM_3:
            return this.test3;
        default:
            throw new InputMismatchException();
        }
    }

    /**
    * <p>Returns a string description of this Student object.</p>
    * 
    * @return formatted name and addresses of student
    */
    public String toString() {
        return firstName + " " + lastName + "\n"
        		+ "Home Address:\n" + homeAddress + "\n"
        		+ "School Address:\n" + schoolAddress + "\n"
        		+ "Test score 1: " + getTestScore(TEST_NUM_1) + "\n"
        		+ "Test score 2: " + getTestScore(TEST_NUM_2) + "\n"
        		+ "Test score 3: " + getTestScore(TEST_NUM_3);
    }
}
