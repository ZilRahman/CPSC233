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

    public void displayMovie() {

        // displays list

        if (head == null) {
            System.out.println();
            System.out.println("This list is empty, there is nothing to display.");
            System.out.println();
        }
        while (head != null) {
            System.out.println();
            System.out.println(head.getData().getMovieName());
            head.getData().getCastMembers();
            System.out.println(head.getData().getGenre());
            System.out.println(head.getData().getRating());
            System.out.println("************");
            head = head.getNext();

        }

    }

    public void searchMovie() {
        Scanner in = new Scanner(System.in);

        if (head == null) {
            System.out.println("Cannot invoke search: List is empty.");
        }

        else {
            System.out.println("Which movie do you want to look for? (case sensitive): ");
            String userInput = in.nextLine();
            while (!head.getData().getMovieName().equals(userInput)) {
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

    public void removeMovie() {

        // empty list
        if (head == null) {
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
                System.out.println("no movie called " + searchName + " in the collection.");
            }

        }

    }

}
