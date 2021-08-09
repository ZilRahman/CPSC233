import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Manager aManager = new Manager();

        UserInterface aUserInterface = new UserInterface(aManager);
        Scanner userSelection = new Scanner(System.in);
        String userChoice;

        do {
            System.out.println("Welcome to movie organizer program!");
            System.out.println("Please select from options below: ");
            System.out.println("(A)dd a movie to the collection");
            System.out.println("(D)isplay movie collection");
            System.out.println("(S)earch movie collection");
            System.out.println("(O)pposite order display");
            System.out.println("(Q)uit the program");
            userChoice = userSelection.nextLine();

            if (userChoice.equals("a")) {
                // display adding movie menu
                aUserInterface.displayMenu();
            }
            if (userChoice.equals("d")) {
                // display movie list
                aManager.displayMovie();

            }
            if (userChoice.equals("s")) {
            }
            if (userChoice.equals("o")) {
            }
        } while (!userChoice.equals("q"));

    }
}
