// Zil's Second Java Assignment May, 17, 2021
// This program is a simple grade management program, it initializes grades and gives user 
// options to find the highest or lowest grade as well as calculating the average grade.

// Starting execution for the program
// Driver class gets user input using the UI class and displayes output working with the Manager 
// class.
public class Driver {
    public static void main(String[] args) {

        // bad naming convention
        Manager aManager = new Manager();

        UI userSelection = new UI();

        int menuNumber = userSelection.displayMenu();

        while (menuNumber != 5) {

            if (menuNumber == 1) {
                aManager.makeGrades();
                menuNumber = userSelection.displayMenu();

            }

            else if (menuNumber == 2) {
                aManager.getAverageGrades();
                menuNumber = userSelection.displayMenu();
            }

            else if (menuNumber == 3) {
                aManager.findHighestGrade();
                menuNumber = userSelection.displayMenu();
            }

            else if (menuNumber == 4) {
                aManager.findLowestGrade();
                menuNumber = userSelection.displayMenu();

            }
        }

        if (menuNumber == 5) {
            userSelection.quitProgram();

        }
    }
}