package q4;

import java.io.File;
import java.util.Scanner;
import q3.Address;
import q3.Student;
import q3.Calculations;

/**
 * <p>Class that manipulates the student data. The following
 * can be achieved:</p>
 * <ul>
 * <li>Open and read a file of student information.</li>
 * <li>Create and add students to list.</li>
 * <li>Calculate the class average.</li>
 * </ul>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Data {
	/**
     * <p>Number of tests each student has taken.</p>
     */
    private static final int TESTS = 3;
    
    /**
     * <p>Maximum number of students allowed in course.</p>
     */
    private static final int MAX = 5;
    
    /**
     * <p> Amount of students that are in the array.</p>
     */
    private int studentAmount;
	
	/**
	 * <p>Calculations object</p>
	 */
	private static Calculations calculations = new Calculations();
	
	/**
	 * <p>Opens a file from a sub-folder inside a root folder.</p>
	 * 
	 * @param root root folder
	 * @param sub sub folder
	 * @param file file
	 * @return file surveyFile
	 */
	public File openFile(String root, String sub, String file) {
		File studentFile = new File(root + File.separator + sub + File.separator
				+ file);
		return studentFile;
	}
	
    /**
     * <p>Class average on all tests taken.</p>
     * 
     * @param myCourse Course with enrollments
     * @return classAverage
     */
	public double classAverage(Course myCourse) {
		double testTotal = 0; //total of all test scores.
		int numTests = 0; //Total number of tests.
		
		for (Student object : myCourse.students) {
			testTotal += calculations.getTestScoreTotal(object);
            numTests += TESTS;
        }
		
        return testTotal / numTests;
	}
	
	/**
	 * <p>Create a new student from the file.</p>
	 * 
	 * @param input student info file
	 * @return student
	 */
	public Student createStudent(Scanner input) {
		Student student;
		
		Address homeAddress = new Address(input.next(), input.next(),
                input.next(), input.next());
        Address schoolAddress = new Address(input.next(), input.next(),
                input.next(), input.next());
        student = new Student(input.next(), input.next(), homeAddress,
                schoolAddress, input.nextDouble(), input.nextDouble(),
                Double.parseDouble(input.next()));
        
        return student;
	}
	
	/**
     * <p>Adds student to the course.</p>
     * 
     * @param student Student to be added.
     */
    public void addStudent(Student student, Course myCourse) {
        if (studentAmount < MAX) {
        	myCourse.students.add(student);
            studentAmount++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }  
    }
}
