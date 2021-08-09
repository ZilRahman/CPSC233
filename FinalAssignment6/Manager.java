import java.util.*;

public class Manager {
    private MovieNode list;

    public Manager() {
        this.list = null;
    }

    public Manager(MovieNode head) {
        this.list = head;
    }

    public void addMovie(Movie aMovie) {
        MovieNode aNode = new MovieNode(aMovie, null);

        if (list == null) {
            list = aNode; // head
        } else {
            MovieNode temp = list;
            // SOMETHING WRONG
            do {
                if (temp.getNext() == null) {
                    temp.addNext(aNode);
                } else {
                    temp = temp.getNext();
                }
            } while (temp.getNext() != null);
        }
    }

    public void displayMovie() {

        // displays list

        if (list == null) {
            System.out.println();
            System.out.println("This list is empty, there is nothing to display.");
            System.out.println();
        }
        while (list != null) {
            System.out.println(list.getData().getMovieName());
            list.getData().getCastMembers();
            System.out.println(list.getData().getGenre());
            System.out.println(list.getData().getRating());
            System.out.println("************");
            list = list.getNext();

        }

    }

    public void searchMovie() {

    }

    public void removeMovie() {

    }

}
