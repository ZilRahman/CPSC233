public class Movie {

    private String movieName;

    private String[] castMembers = new String[3];

    private String genre;

    private int rating;

    // constructor with four attributes
    public Movie(String movieName, String[] castMembers, String genre, int rating) {
        this.movieName = movieName;
        this.castMembers = castMembers;
        this.genre = genre;
        this.rating = rating;
    }

}
