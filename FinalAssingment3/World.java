
public class World {

    private Entity[][] oldEntityArray;

    private Entity[][] newEntityArray;

    public World(Entity[][] oldEntityArray) {
        this.oldEntityArray = oldEntityArray;
        Entity[][] newEntityArray = new Entity[10][10];
        this.newEntityArray = newEntityArray;
    }

    public void traverseWorld() {

        // sweep motion loop for bottom right to top left for Orcs
        for (int r = 9; r >= 0; r--) {
            for (int c = 9; c >= 0; c--) {
                // check if array object is not null
                if (oldEntityArray[r][c] != null) {
                    // check if array object is an Orc
                    if (oldEntityArray[r][c].getAppearance().equals("O")) {
                        moveOrc(r, c);
                    }
                }
            }
        }

        // sweep motion loop for top left to bottom right for Dwarves
        for (int r = 0; r <= 9; r++) {
            for (int c = 0; c <= 9; c++) {
                // check if array object is not null
                if (oldEntityArray[r][c] != null) {

                    // check if array object is a Dwarf
                    if (oldEntityArray[r][c].getAppearance().equals("D")) {
                        moveDwarf(r, c);
                    }
                }
            }
        }

        displayWorld();

        // change array here?
        swapArrays();
    }

    // move orc
    private void moveOrc(int r, int c) {
        Entity orc = oldEntityArray[r][c];
        int newRow = r + 1;
        int newCol = c + 1;
        if (newRow < oldEntityArray.length & newCol < oldEntityArray.length) {
            if (newEntityArray[newRow][newCol] == null) {
                newEntityArray[newRow][newCol] = orc;
            } else {
                newEntityArray[r][c] = orc;
            }
        }
        // grounding the Orc
        else {
            newEntityArray[r][c] = orc;
        }
    }

    // moves dwarfs function
    private void moveDwarf(int r, int c) {
        Entity dwarf = oldEntityArray[r][c];
        int newRow = r - 1;
        int newCol = c - 1;

        // move dwarf
        if (newRow > 0 & newCol > 0) {

            // move dwarf
            if (newEntityArray[newRow][newCol] == null) {
                newEntityArray[newRow][newCol] = dwarf;
                // checkNeighborsDwarf(r, c, dwarf); // checking neighbors
                // oldEntityArray[r][c] = null;
            } else {
                newEntityArray[r][c] = dwarf;
            }
        }

        // grounding the dwarf
        else {
            newEntityArray[r][c] = dwarf;
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

    // the new entity array is the same as the one in moveDwarf function?
    private void checkNeighborsDwarf(int r, int c, Entity dwarf) {
        // left side Orc neighbor
        if (r >= 0 & c - 1 >= 0) {
            if (oldEntityArray[r][c - 1] != null) {
                if (oldEntityArray[r][c - 1].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;
                }
            }
        }
        // right side Orc neighbor
        else if (r <= 9 & c + 1 <= 9) {
            if (oldEntityArray[r][c + 1] != null) {
                if (oldEntityArray[r][c + 1].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;

                }
            }
        }
        // top neighbor
        else if (r - 1 >= 0 & c >= 0) {
            if (oldEntityArray[r - 1][c] != null) {
                if (oldEntityArray[r - 1][c].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;
                }
            }
        }
        // bottom neighbor
        else if (r + 1 >= 9 & c >= 9) {
            if (oldEntityArray[r + 1][c] != null) {
                if (oldEntityArray[r + 1][c].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;
                }
            }
        }

        // top left neighbor
        else if (r - 1 >= 0 & c - 1 >= 0) {
            if (oldEntityArray[r - 1][c - 1] != null) {
                if (oldEntityArray[r - 1][c - 1].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;
                }
            }
        }

        // top right neighbor
        else if (r - 1 >= 9 & c + 1 >= 9) {
            if (oldEntityArray[r - 1][c + 1] != null) {
                if (oldEntityArray[r - 1][c + 1].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;
                }
            }
        }

        // bottom left neighbor
        else if (r + 1 >= 9 & c - 1 >= 9) {
            if (oldEntityArray[r + 1][c - 1] != null) {
                if (oldEntityArray[r + 1][c - 1].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;
                }
            }
        }

        // bottom right neighbor
        else if (r + 1 >= 9 & c + 1 >= 9) {
            if (oldEntityArray[r + 1][c + 1] != null) {
                if (oldEntityArray[r + 1][c + 1].getAppearance().equals("O")) {
                    newEntityArray[r][c] = dwarf;
                }
            }
        }

        else {
            newEntityArray[r][c] = dwarf;
        }
    }

}