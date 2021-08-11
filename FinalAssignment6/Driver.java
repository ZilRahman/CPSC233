import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Manager aManager = new Manager();

        UserInterface aUserInterface = new UserInterface(aManager);
        Scanner userSelection = new Scanner(System.in);
        String userChoice;

        do {
            System.out.println();
            System.out.println("Welcome to movie organizer program!");
            System.out.println("Please select from options below: ");
            System.out.println("(a)dd a movie to the collection");
            System.out.println("(d)isplay movie collection");
            System.out.println("(s)earch movie collection");
            System.out.println("(r)emove movie from collection");
            System.out.println("(o)pposite order display");
            System.out.println("(q)uit the program");
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
                // search movie list
                aManager.searchMovie();
            }
            if (userChoice.equals("r")) {
                // removes movie from list
                aManager.removeMovie();
            }
            if (userChoice.equals("o")) {
                // displays collection in opposite order
                aManager.displayRecursive();

            }
        } while (!userChoice.equals("q"));

    }
}
