package q4;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import q3.Student;

/**
 * <p>Driver class adds students to a course, lists the 
 * names of the students and the class average for 
 * all tests taken.</p>
 *
 * @author Jason Kolenosky
 * @version 2.0
 */
public class TestCourse {

    /**
     * <p>Student object.</p>
     */
    private static Student student;
    
    /**
     * <p>Scanner object.</p>
     */
    static Scanner input;
    
    /**
     * Data object to manipulate information.</p>
     */
    private static Data data = new Data();
    
    /**
     * Console object to display information.</p>
     */
    private static Console console = new Console();

    /**
     * <p>The main method for the course program.</p>
     *
     * @param args unused
     * @throws FileNotFoundException File not found exception.
     */
    public static void main(String[] args) throws FileNotFoundException {
    	double classAverage = 0; 
    	
    	//Create file.
        try {
            input = new Scanner(data.openFile("src", "q4", "studentInfo.txt"));
        } catch (FileNotFoundException e) {
            console.fileNotFound();
        }
        
        //Create new course.
        Course myCourse = new Course("Math");
        
        //Add students to course.
        while (input.hasNext()) {
            input.useDelimiter(",");
            try {
            	student = data.createStudent(input);
            } catch (NoSuchElementException e) {
                console.informationError();
                break;
            } catch (NumberFormatException e) {
                console.invalidTest();
                break;
            }

            try {
                data.addStudent(student, myCourse);
            } catch (ArrayIndexOutOfBoundsException e) {
                console.arraySizeError();
            }
        }
        
        //Display students registered in course.
        console.displayStudents(myCourse.rollCall());
        classAverage = data.classAverage(myCourse);
        console.displayClassAverage(classAverage);

        input.close();
    }
};
