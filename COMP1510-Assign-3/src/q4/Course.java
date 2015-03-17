package q4;

import java.util.ArrayList;

import q3.Student;

/**
 * <p>Course constructor that is created using a name paramater.<p>
 * <p>This class uses the following methods:</p>
 * <ul>
 * <li>Add students to the course.</li>
 * <li>Test average for the course.</li>
 * <li>Description of who is registered in the course.</li>
 * </ul>
 * 
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Course {
    
    /**
     * <p>Maximum number of students allowed in course.</p>
     */
    private static final int MAX = 5;
    
    /**
     * <p>Number of tests each student has taken.</p>
     */
    private static final int TESTS = 3;
    
    /**
     * <p>Course name.</p>
     */
    private String courseName;

    /**
     * <p>Arraylist of students taking the course.</p>
     */
    private ArrayList<Student> students;

    /**
     * <p>Total of all the students' test scores.</p>
     */
    private double wholeTotal;

    /**
     * <p> Amount of students that are in the array.</p>
     */
    private int studentAmount;
    
    /**
     * <p>Total number of tests taken for all students.</p>
     */
    private int numTests;

    /**
     * <p>Course constructor with only name as parameter.<.p>
     * 
     * @param name Course name.
     */
    public Course(String name) {
        courseName = name;
        students = new ArrayList<Student>();
    }

    /**
     * <p>Adds student to the course.</p>
     * 
     * @param student Student to be added.
     */
    public void addStudent(Student student) {
        if (studentAmount < MAX) {
            students.add(student);
            studentAmount++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }  
    }

    /**
     * <p>Average test scores for all students.</p>
     * 
     * @return classAverage
     */
    public double average() {
        for (Student object : students) {
            wholeTotal += object.getTestScoreTotal();
            numTests += TESTS;
        }
        double classAverage = wholeTotal / numTests;
        return classAverage;
    }

    /**
     * <p>Prints the names of the students in the course.</p>
     */
    public void roll() {
        System.out.print("Students Registered in " + courseName + "\n");
        for (Student object : students) {
            System.out.println(object.getName());
        }
        System.out.println();
    }
}
