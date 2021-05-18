// Zil's Second Java Assingment May, 17, 2021
// This program is a simple grade management program, it initializes grades and gives user 
// options to find the highest or lowest grade as well as calculating the average grade.

// Starting execution for the program
// Driver class gets user input using the UI class and displayes output working with the Manager 
// class.
public class Driver {
    public static void main(String[] args) {

        Manager test = new Manager();

        UI userSelection = new UI();
        System.out.println("Welcome to Grade Manager, please select from menu options below:");
        int menuNumber = userSelection.displayMenu();

        while (menuNumber != 5) {

            if (menuNumber == 1) {
                test.makeGrades();
                menuNumber = userSelection.displayMenu();

            }

            else if (menuNumber == 2) {
                test.getAverageGrades();
                menuNumber = userSelection.displayMenu();
            }

            else if (menuNumber == 3) {
                test.findHighestGrade();
                menuNumber = userSelection.displayMenu();
            }

            else if (menuNumber == 4) {
                test.findLowestGrade();
                menuNumber = userSelection.displayMenu();

            }

            else if (menuNumber == 5) {
                System.out.print("You have decided to quit the program");
                return;
            }

        }
    }
}