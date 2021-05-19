import java.util.Random;
import java.text.DecimalFormat;

// Manager class is responsible for storing and manipulating grades data and has methods that 
// correlate with the Driver class.
public class Manager {

    private float[] grades;
    private float gradeSum = 0;
    private int listNumber = 0;

    // makeGrades() is a mutator method that must run first in the program for the
    // rest of the methods to work
    // it instantiates the grades list randomly using the Random class from java
    // utilities.
    public void makeGrades() {
        Random randomGrades = new Random();
        grades = new float[40];

        // assings first ten grades 2.0
        for (int i = 0; i < 10; i++) {
            grades[i] = (float) 2.0;
            System.out.println(grades[i]);
            listNumber++;
            gradeSum = gradeSum + grades[i];
        }

        // randomizes thirty grades totalling grades to a float list of forty.
        for (int i = 10; i < grades.length; i++) {
            grades[i] = (float) (randomGrades.nextInt(40 - 0 + 0) + 0) / (float) 10.0;

            System.out.println(grades[i]);
            listNumber++;
            gradeSum = gradeSum + grades[i];
        }

    }

    // getAverageGrade() is a mutator method which calculates the average grade in
    // the instantiated list.
    public void getAverageGrades() {
        float averageGrade = gradeSum / listNumber;
        DecimalFormat df = new DecimalFormat("##.0");

        String averageGradeString = df.format(averageGrade);
        System.out.println("Average grade in a list of " + listNumber + " grades is " + averageGradeString);

    }

    // findHighestGrade() is a mutator method that parses grades[] and finds the
    // highest grade in the list,
    // the result is displayed in a print statement.
    public void findHighestGrade() {
        float maxValue = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > maxValue) {
                maxValue = grades[i];
            }
        }
        System.out.println("Highest grade in the list is " + maxValue);
    }

    // findLowestGrade() is a mutator method that parses grades[] and finds the
    // lowest grade in the list,
    // the result is displayed in a print statement.
    public void findLowestGrade() {
        float minValue = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < minValue) {
                minValue = grades[i];
            }
        }
        System.out.println("Lowest grade in the list is " + minValue);
    }
}
