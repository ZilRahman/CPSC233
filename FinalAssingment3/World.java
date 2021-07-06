import java.util.Set;

public class World {

    private Entity[][] oldEntityArray;

    private Entity[][] newEntityArray;

    public World(Entity[][] oldEntityArray) {
        this.oldEntityArray = oldEntityArray;
        Entity[][] newEntityArray = new Entity[10][10];
        this.newEntityArray = newEntityArray;
    }

    public void traverseWorld() {

        // for loop for traversing Entity array
        for (int r = 0; r < oldEntityArray.length; r++) {
            for (int c = 0; c < oldEntityArray.length; c++) {
                // check if array object is not null
                if (oldEntityArray[r][c] != null) {
                    // check if array object is an Orc
                    if (oldEntityArray[r][c].getAppearance().equals("O")) {
                        moveOrc(r, c);
                    }
                    // check if array object is a Dwarf
                    else if (oldEntityArray[r][c].getAppearance().equals("D")) {
                        moveDwarf(r, c);
                    }
                }
            }
        }
        // change array here?
        swapArrays();
    }

    private void moveOrc(int r, int c) {
        Entity orc = oldEntityArray[r][c];
        int newRow = r + 1;
        int newCol = c + 1;
        if (newRow < oldEntityArray.length & newCol < oldEntityArray.length) {
            if (oldEntityArray[newRow][newCol] == null) {
                newEntityArray[newRow][newCol] = orc;
                oldEntityArray[r][c] = null;
            }
        }
    }

    // moves dwarfs
    private void moveDwarf(int r, int c) {
        Entity dwarf = oldEntityArray[r][c];
        int newRow = r - 1;
        int newCol = c - 1;
        if (newRow > 0 & newCol > 0) {
            if (oldEntityArray[newRow][newCol] == null) {
                newEntityArray[newRow][newCol] = dwarf;
                oldEntityArray[r][c] = null;
            }
        }
    }

    public void displayWorld() {
        System.out.println("\nBefore");
        // prints old world
        for (int r = 0; r < oldEntityArray.length; r++) {
            System.out.println();
            for (int c = 0; c < oldEntityArray.length; c++) {
                if (oldEntityArray[r][c] != null) {
                    System.out.print(oldEntityArray[r][c].getAppearance());
                    // System.out.print(newEntityArray[r][c].getAppearance());
                } else {
                    System.out.print(".");
                }
            }
        }

        System.out.println("\nAfter");

        // prints new world
        if (newEntityArray != null) {
            for (int r = 0; r < newEntityArray.length; r++) {
                System.out.println();
                for (int c = 0; c < newEntityArray.length; c++) {
                    if (newEntityArray[r][c] != null) {
                        // System.out.print(oldEntityArray[r][c].getAppearance());
                        System.out.print(newEntityArray[r][c].getAppearance());
                    } else {
                        System.out.print(".");
                    }
                }
            }
        }

        // or change array here?
    }

    private void swapArrays() {
        oldEntityArray = newEntityArray;
        newEntityArray = null;
        // make newEntityArray new array of 10x10
        newEntityArray = new Entity[10][10];
    }

}