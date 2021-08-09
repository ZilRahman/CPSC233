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

    public String getMovieName() {
        return movieName;
    }

    public void getCastMembers() {
        for (int i = 0; i < castMembers.length; i++) {
            System.out.println(castMembers[i]);
        }
        // return castMembers;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }
}
