package q4;

import java.util.ArrayList;
import q3.Student;

/**
 * <p>Course constructor that is created using a name parameter.<p>
 * <p>This class uses the following methods:</p>
 * <ul>
 * <li>Add students to the course.</li>
 * <li>Test average for the course.</li>
 * <li>Description of who is registered in the course.</li>
 * </ul>
 * 
 * @author Jason Kolenosky
 * @version 2.0
 */
public class Course {
    /**
     * <p>Course name.</p>
     */
    private String courseName;

    /**
     * <p>Arraylist of students taking the course.</p>
     */
    ArrayList<Student> students;

    /**
     * <p>Course constructor.</p>
     * 
     * @param name Course name
     */
    public Course(String name) {
        courseName = name;
        students = new ArrayList<Student>();
    }

    /**
     * <p>Prints the names of the students in the course.</p>
     */
    public String rollCall() {
    	String studentList = "";
    	
        System.out.print("Students Registered in " + courseName + "\n");
        for (Student object : students) {
            studentList += object.getName() + "\n";
        }
        
        return studentList;
    }
}
