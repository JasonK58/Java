package q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import q3.Address;
import q3.Student;

/**
 * <p>This class adds students to a course, lists the names of the students
 *  and the class average for all the tests taken.</p>
 *
 * @author Jason Kolenosky
 * @version 1.0
 */
public class TestCourse {

    /**
     * <p>Empty student object.</p>
     */
    private static Student object;

    /**
     * <p>The main method for the course.</p>
     *
     * @param args command line arguments.
     * @throws FileNotFoundException File not found exception.
     */
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src" + File.separator + "q4" + File.separator
                + "studentInfo.txt");

        Scanner input = new Scanner(file);

        Course myCourse = new Course("Math");

        while (input.hasNext()) {

            input.useDelimiter(",");

            try {
                Address homeAddress = new Address(input.next(), input.next(),
                        input.next(), input.next());
                Address schoolAddress = new Address(input.next(), input.next(),
                        input.next(), input.next());
                object = new Student(input.next(), input.next(), homeAddress,
                        schoolAddress, input.nextDouble(), input.nextDouble(),
                        Double.parseDouble(input.next()));
            } catch (NoSuchElementException e) {
                System.out.println("There is no not enough information to "
                        + "add an additional student.\nCheck your file.\n");
                break;
            } catch (NumberFormatException e) {
                System.out.println("The test result you entered is not valid."
                        + " The student has not been added." 
                        + "\nCheck your file.\n");
                break;
            }

            try {
                myCourse.addStudent(object);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out
                        .println("The array is not large enough "
                                + "to add another student.\n");
            }
        }

        myCourse.roll();
        System.out.println("The class average is: "
                + Math.round(myCourse.average()) + "%\n");
        System.out.println("Question four was called and ran sucessfully.");
        input.close();
    }
};
