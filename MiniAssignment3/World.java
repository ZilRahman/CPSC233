
public class World {

    private final int SIZE = 5;
    private Entity[][] world = new Entity[SIZE][SIZE];
    private int r;
    private int c;

    private int oldRow = 1;
    private int oldColumn = 1;

    private Entity thing;

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
