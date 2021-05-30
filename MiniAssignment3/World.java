// Class World is responsible for instantiating the 2d array (5x5) and placing 
// on entity object inside. It's method also places an entity wherever the user
// wishes to place and displays the new world using another printWorld() method.

public class World {

    private final int SIZE = 5;
    private Entity[][] world = new Entity[SIZE][SIZE];
    private int r;
    private int c;

    private int oldRow = 1;
    private int oldColumn = 1;

    private Entity thing;

    // World() constructor sets all the starting values in the 2d array to null and
    // instantiates array.
    public World() {

        thing = new Entity();

        // Making 2d array
        for (r = 0; r < SIZE; r++) {
            System.out.println(" - - - - - ");
            System.out.println("| | | | | |");
            for (c = 0; c < SIZE; c++) {
                world[r][c] = null;
            }
        }

    }

    // getAppearance() resets old entity object so previous area is null in 2d array
    public void getAppearance() {

        world[oldRow][oldColumn] = thing;

        printWorld();
    }

    public void move(int row, int column) {

        world[row][column] = thing;

        world[oldRow][oldColumn] = null;

        oldRow = row;
        oldColumn = column;
    }

    // printWorld() is responsible for displaying the 2d array and the object Entity
    // within.
    public void printWorld() {

        for (r = 0; r < SIZE; r++) {
            System.out.println(" ");
            for (c = 0; c < SIZE; c++) {
                if (world[r][c] == null) {
                    System.out.print("|  |\t");
                } else {
                    System.out.print("|" + world[r][c] + "|\t");
                }
            }
        }
    }

}
