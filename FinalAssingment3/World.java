import java.util.Set;

public class World {

    private Entity[][] myEntityArray;

    public World(Entity[][] myEntityArray) {
        this.myEntityArray = myEntityArray;
        displayWorld();
        traverseWorld();
        displayWorld();
    }

    private void traverseWorld() {
        // for loop for traversing Entity array
        for (int r = 0; r < myEntityArray.length; r++) {
            for (int c = 0; c < myEntityArray.length; c++) {
                // check if array object is not null
                if (myEntityArray[r][c] != null) {
                    // check if array object is an Orc
                    if (myEntityArray[r][c].getAppearance().equals("O")) {
                        moveOrc(r, c);

                    }
                    // check if array object is a Dwarf
                    // else if (myEntityArray[r][c].getAppearance().equals("D")) {
                    // moveDwarf(r, c);

                    // }
                }
            }
        }
    }

    private void moveOrc(int r, int c) {
        Entity orc = myEntityArray[r][c];
        if (r + 1 < myEntityArray.length & c + 1 < myEntityArray.length) {
            if (myEntityArray[r + 1][c + 1] == null) {
                myEntityArray[r + 1][c + 1] = orc;
                myEntityArray[r][c] = null;
            }
        }

    }

    private void moveDwarf(int r, int c) {
        Entity dwarf = myEntityArray[r][c];
        if (r - 1 < myEntityArray.length & c - 1 < myEntityArray.length) {
            if (myEntityArray[r - 1][c - 1] == null) {
                myEntityArray[r - 1][c - 1] = dwarf;
                myEntityArray[r][c] = null;
            }
        }

    }

    private void displayWorld() {
        System.out.println();
        for (int r = 0; r < myEntityArray.length; r++) {
            System.out.println();
            for (int c = 0; c < myEntityArray.length; c++) {
                if (myEntityArray[r][c] != null) {
                    System.out.print(myEntityArray[r][c].getAppearance());
                } else {
                    System.out.print(".");
                }
            }
        }

    }

}