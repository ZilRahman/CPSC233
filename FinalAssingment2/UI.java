import java.util.Scanner;

// UI class is responsible for displaying the menu and only has one function which
// displays the menu and gets user input which it returns to the Driver class.
public class UI {

    public int displayMenu() {
        System.out.println("(1) display grades");
        System.out.println("(2) Find average grade");
        System.out.println("(3) Find highest grade");
        System.out.println("(4) Find lowest grade");
        System.out.println("(5) Quit the program");

        Scanner userInput = new Scanner(System.in);
        System.out.println("please select menu option");

        int menuNumber = userInput.nextInt();

        while (menuNumber < 1 || menuNumber > 5) {
            System.out.println("Thats not a valid selection, please choose a menu option displayed.");
            menuNumber = userInput.nextInt();
        }

        return menuNumber;
    }
}
