import java.util.*;

public class UserInterface {

    // function to get movie name from user and return it.
    public String getMovieName() {
        System.out.println("Enter movie name: ");
        Scanner userMovieName = new Scanner(System.in);

        String movieName = userMovieName.nextLine();
        System.out.println("Movie: " + movieName);

        userMovieName.close();

        return movieName;

    }

    // function to get a list of 3 cast members from user and return list.
    public String[] getCast() {

        String[] castMembers = new String[3];

        for (int i = 0; i == 3; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter #" + i + " cast member (3 MAX): ");
            castMembers[i] = in.nextLine();

            in.close();
        }
        return castMembers;

    }

    // function to get genre of movie from user and return it.
    public String getGenre() {

        System.out.println("Which genre is this movie?:  ");
        Scanner in = new Scanner(System.in);
        String genreSelected = in.nextLine();

        in.close();
        return genreSelected;

    }

    // function to get rating of movie from user and return it.
    public int getRating() {
        System.out.println("How would you rate this movie? 1(low) - 5(high): ");
        Scanner in = new Scanner(System.in);
        int getRating = in.nextInt();

        in.close();
        return getRating;

    }
}
