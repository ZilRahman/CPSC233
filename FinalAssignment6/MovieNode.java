
public class MovieNode {
    private Movie data;
    private MovieNode next;

    public MovieNode() {
        this.next = null;
        this.data = null;
    }

    public MovieNode(Movie data, MovieNode next) {
        this.data = data;
        this.next = next;
    }

    public void addNext(MovieNode node) {
        this.next = node;
    }

    public MovieNode getNext() {
        return next;
    }

    public void setNext(MovieNode next) {
        this.next = next;
    }

    public Movie getData() {
        return data;
    }

    public void setData(Movie data) {
        this.data = data;
    }

}