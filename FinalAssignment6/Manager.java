import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class Manager {
    private MovieNode head;

    public Manager() {
        this.head = null;
    }

    public Manager(MovieNode head) {
        this.head = head;
    }

    // adds movie to linked list
    public void addMovie(Movie aMovie) {
        MovieNode aNode = new MovieNode(aMovie, null);

        if (head == null) {
            head = aNode; // head node assigned
        } else {
            MovieNode current = head;
            MovieNode previous = null;

            while (current != null) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(aNode);

        }
    }

    // displays list
    public void displayMovie() {

        // displays list
        MovieNode temp = head;
        if (temp == null) {
            System.out.println();
            System.out.println("This list is empty, there is nothing to display.");
            System.out.println();
        }
        while (temp != null) {
            System.out.println();
            System.out.println(temp.getData().getMovieName());
            temp.getData().getCastMembers();
            System.out.println(temp.getData().getGenre());
            System.out.println(temp.getData().getRating());
            System.out.println("************");
            temp = temp.getNext();
        }

    }

    // searches for movie from list based on user input
    public void searchMovie() {
        Scanner in = new Scanner(System.in);

        if (head == null) {
            System.out.println();
            System.out.println("Cannot invoke search: List is empty.");
        }

        else {
            System.out.println();
            System.out.println("Which movie do you want to look for? (case sensitive): ");
            String userInput = in.nextLine();
            while (!head.getData().getMovieName().equals(userInput)) {
                System.out.println();
                System.out.println("Searching...");
                head = head.getNext();
                if (head.getData().getMovieName().equals(userInput)) {
                    System.out.println();
                    System.out.println("Match found! Details of your search are below...");
                    System.out.println();
                    System.out.println(head.getData().getMovieName());
                    head.getData().getCastMembers();
                    System.out.println(head.getData().getGenre());
                    System.out.println(head.getData().getRating());
                    System.out.println("************");
                    System.out.println();
                }
            }
        }
    }

    // removes user given movie from list
    public void removeMovie() {

        // empty list
        if (head == null) {
            System.out.println();
            System.out.println("List is empty; nothing to remove");
        }

        // non-empty list
        else {
            MovieNode previous = null;
            MovieNode current = head;
            String searchName = null;
            boolean isFound = false;
            String currentName;
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter name of movie you want to remove: ");
            searchName = in.nextLine(); // user selects name

            // Determine if match exists
            // current points to node to delete
            // previous is one node prior
            while ((current != null) && (isFound == false)) {
                currentName = current.getData().getMovieName();
                if (searchName.equals(currentName)) {
                    isFound = true; // match found stop traversal
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
            // match found (remove movieNode)
            if (isFound == true) {
                System.out.println();
                System.out.println("Removing movie called " + searchName);

                // remove first node
                if (previous == null) {
                    head = head.getNext();
                }
                // remove any node except for first
                else {
                    previous.setNext(current.getNext());
                }

            }
            // no matches found
            else {
                System.out.println();
                System.out.println("no movie called " + searchName + " in the collection.");
            }

        }

    }

    // shows the list in opposite order
    public void displayRecursive() {
        MovieNode temp = head;

        // empty list
        if (temp == null) {
            System.out.println("collection is empty; nothing to display");
        }

        // non-empty list
        else {
            int count = 1;
            displayAndRecursive(temp, count);
        }
    }

    // recursive function called from oppositeDisplay()
    public void displayAndRecursive(MovieNode temp, int count) {

        // check if next is null or not
        // if next is null, dont call it
        // print myself

        if (temp.getNext() != null) {
            count++;
            displayAndRecursive(temp.getNext(), count);

        }

        // print movie details here
        System.out.println();
        System.out.println(temp.getData().getMovieName());
        temp.getData().getCastMembers();
        System.out.println(temp.getData().getGenre());
        System.out.println(temp.getData().getRating());
        System.out.println("************");

    }
}
