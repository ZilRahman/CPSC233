import java.util.*;

public class UserInterface {

    Manager aManager;

    public UserInterface(Manager aManager) {
        this.aManager = aManager;
    }

    public void displayMenu() {
        String movieName = getMovieName();
        String[] castMembers = getCast();
        String movieGenre = getGenre();
        int movieRating = getRating();

        Movie aMovie = new Movie(movieName, castMembers, movieGenre, movieRating);
        aManager.addMovie(aMovie);
        repeatMenu();
    }

    // function to repeat menu upon user selection
    public void repeatMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("Would you like to continue(y) or quit(n)?");
        String userSelection = in.nextLine();

        if (userSelection.equals("y")) {
            System.out.println("You have chosen to continue!");
            displayMenu();
        } else {
            System.out.println("You have chosen to quit!");

        }

    }

    // function to get movie name from user and return it.
    public String getMovieName() {
        System.out.println("Enter movie name: ");
        Scanner userMovieName = new Scanner(System.in);

        String movieName = userMovieName.nextLine();
        System.out.println("Movie: " + movieName);

        return movieName;

    }

    // function to get a list of 3 cast members from user and return list.
    public String[] getCast() {

        String[] castMembers = new String[3];
        Scanner in = new Scanner(System.in);

        int count = 1;

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter #" + count + " cast member (3 MAX): ");
            castMembers[i] = in.nextLine();
            System.out.println("Cast #" + count + " " + castMembers[i]);
            count++;

        }
        return castMembers;

    }

    // function to get genre of movie from user and return it.
    public String getGenre() {

        System.out.println("Which genre is this movie?:  ");
        Scanner in = new Scanner(System.in);
        String genreSelected = in.nextLine();
        System.out.println("Movie Genre: " + genreSelected);

        return genreSelected;

    }

    // function to get rating of movie from user and return it.
    public int getRating() {
        System.out.println("How would you rate this movie? 1(low) - 5(high): ");
        Scanner in = new Scanner(System.in);
        int getRating = in.nextInt();

        return getRating;

    }
}
