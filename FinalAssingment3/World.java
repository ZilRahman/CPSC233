import java.util.Random;

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

        for (int r = 0; r <= 9; r++) {
            for (int c = 0; c <= 9; c++) {
                if (newEntityArray[r][c] != null) {
                    if (newEntityArray[r][c].getAppearance().equals("O")) {

                        // Orc attack and health analysis run round-by-round
                        boolean neighborFound = checkNeighborsOrc(r, c, newEntityArray[r][c]);
                        if (neighborFound) {

                            int orcAttackHit = generateAttackDwarf();
                            int orcHealth = newEntityArray[r][c].getHealth();
                            orcHealth = orcHealth - orcAttackHit;
                            newEntityArray[r][c].setHealth(orcHealth);
                            System.out.println("orc health: " + orcHealth);

                            // if health of orcs fall or equals below zero
                            if (orcHealth <= 0) {
                                System.out.println("an orc has fallen");
                                newEntityArray[r][c] = null;
                            }
                        }
                    } else {
                        // Dwarf attack and health analysis run round-by-round

                        boolean neighborFound = checkNeighborsDwarf(r, c, newEntityArray[r][c]);

                        if (neighborFound) {
                            int dwarfAttackHit = generateAttackOrc();
                            int dwarfHealth = newEntityArray[r][c].getHealth();
                            dwarfHealth = dwarfHealth - dwarfAttackHit;
                            newEntityArray[r][c].setHealth(dwarfHealth);
                            System.out.println("Dwarf health: " + dwarfHealth);

                            // if health of orcs fall or equals below zero
                            if (dwarfHealth <= 0) {
                                System.out.println("a Dwarf has fallen");
                                newEntityArray[r][c] = null;
                            }

                        }
                    }
                }
            }
        }

        displayWorld();

        // change array here?
        swapArrays();
    }

    // move orc function
    private void moveOrc(int r, int c) {
        Entity orc = oldEntityArray[r][c];
        int newRow = r + 1;
        int newCol = c + 1;
        if (newRow <= 9 & newCol <= 9) {

            // check for dwarves around orcs
            if (checkNeighborsOrc(r, c, orc) == true) {
                newEntityArray[r][c] = orc;
            }

            else if (newEntityArray[newRow][newCol] == null) {
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

    // moves dwarf function
    private void moveDwarf(int r, int c) {
        Entity dwarf = oldEntityArray[r][c];
        int newRow = r - 1;
        int newCol = c - 1;

        // move dwarf
        if (newRow > 0 & newCol > 0) {

            // Check for orcs around dwarves
            if (checkNeighborsDwarf(r, c, dwarf) == true) {
                newEntityArray[r][c] = dwarf;
            }

            // Move dwarf only if there is no neighbors and no dwarf where you are headed.
            else if (newEntityArray[newRow][newCol] == null) {
                newEntityArray[newRow][newCol] = dwarf;
            } else {
                newEntityArray[r][c] = dwarf;
            }
        }

        // grounding the dwarf
        else {
            newEntityArray[r][c] = dwarf;
        }
    }

    // displays world before and after traverseWorld()
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

    // old and new arrays for World are swapped and is called upon in
    // traverseWorld()
    private void swapArrays() {
        oldEntityArray = newEntityArray;
        newEntityArray = null;
        // make newEntityArray new array of 10x10
        newEntityArray = new Entity[10][10];
    }

    // full sweep checks for moveDwarf() to determine if there is any Orcs around
    // them
    // returns a boolean flag (true/false)
    private boolean checkNeighborsDwarf(int r, int c, Entity dwarf) {
        // left side Orc neighbor
        if (r >= 0 & c - 1 >= 0) {
            if (oldEntityArray[r][c - 1] != null) {
                if (oldEntityArray[r][c - 1].getAppearance().equals("O")) {
                    return true;
                }
            }
        }
        // right side Orc neighbor
        if (r <= 9 & c + 1 <= 9) {
            if (oldEntityArray[r][c + 1] != null) {
                if (oldEntityArray[r][c + 1].getAppearance().equals("O")) {
                    return true;

                }
            }
        }
        // top neighbor
        if (r - 1 >= 0 & c >= 0) {
            if (oldEntityArray[r - 1][c] != null) {
                if (oldEntityArray[r - 1][c].getAppearance().equals("O")) {
                    return true;
                }
            }
        }
        // bottom neighbor
        if (r + 1 >= 9 & c >= 9) {
            if (oldEntityArray[r + 1][c] != null) {
                if (oldEntityArray[r + 1][c].getAppearance().equals("O")) {
                    return true;
                }
            }
        }

        // top left neighbor
        if (r - 1 >= 0 & c - 1 >= 0) {
            if (oldEntityArray[r - 1][c - 1] != null) {
                if (oldEntityArray[r - 1][c - 1].getAppearance().equals("O")) {
                    return true;
                }
            }
        }

        // top right neighbor
        if (r - 1 >= 9 & c + 1 >= 9) {
            if (oldEntityArray[r - 1][c + 1] != null) {
                if (oldEntityArray[r - 1][c + 1].getAppearance().equals("O")) {
                    return true;
                }
            }
        }

        // bottom left neighbor
        if (r + 1 >= 9 & c - 1 >= 9) {
            if (oldEntityArray[r + 1][c - 1] != null) {
                if (oldEntityArray[r + 1][c - 1].getAppearance().equals("O")) {
                    return true;
                }
            }
        }

        // bottom right neighbor
        if (r + 1 >= 9 & c + 1 >= 9) {
            if (oldEntityArray[r + 1][c + 1] != null) {
                if (oldEntityArray[r + 1][c + 1].getAppearance().equals("O")) {
                    return true;
                }
            }
        }

        return false;
    }

    // full sweep checks for moveOrc() to determine if there is any dwarfs around
    // them
    // returns a boolean flag (true/false)
    private boolean checkNeighborsOrc(int r, int c, Entity orc) {
        // left side Orc neighbor
        if (r >= 0 & c - 1 >= 0) {
            if (oldEntityArray[r][c - 1] != null) {
                if (oldEntityArray[r][c - 1].getAppearance().equals("D")) {
                    return true;
                }
            }
        }
        // right side Orc neighbor
        if (r <= 9 & c + 1 <= 9) {
            if (oldEntityArray[r][c + 1] != null) {
                if (oldEntityArray[r][c + 1].getAppearance().equals("D")) {
                    return true;

                }
            }
        }
        // top neighbor
        if (r - 1 >= 0 & c >= 0) {
            if (oldEntityArray[r - 1][c] != null) {
                if (oldEntityArray[r - 1][c].getAppearance().equals("D")) {
                    return true;
                }
            }
        }
        // bottom neighbor
        if (r + 1 >= 9 & c >= 9) {
            if (oldEntityArray[r + 1][c] != null) {
                if (oldEntityArray[r + 1][c].getAppearance().equals("D")) {
                    return true;
                }
            }
        }

        // top left neighbor
        if (r - 1 >= 0 & c - 1 >= 0) {
            if (oldEntityArray[r - 1][c - 1] != null) {
                if (oldEntityArray[r - 1][c - 1].getAppearance().equals("D")) {
                    return true;
                }
            }
        }

        // top right neighbor
        if (r - 1 >= 9 & c + 1 >= 9) {
            if (oldEntityArray[r - 1][c + 1] != null) {
                if (oldEntityArray[r - 1][c + 1].getAppearance().equals("D")) {
                    return true;
                }
            }
        }

        // bottom left neighbor
        if (r + 1 >= 9 & c - 1 >= 9) {
            if (oldEntityArray[r + 1][c - 1] != null) {
                if (oldEntityArray[r + 1][c - 1].getAppearance().equals("D")) {
                    return true;
                }
            }
        }

        // bottom right neighbor
        if (r + 1 >= 9 & c + 1 >= 9) {
            if (oldEntityArray[r + 1][c + 1] != null) {
                if (oldEntityArray[r + 1][c + 1].getAppearance().equals("D")) {
                    return true;
                }
            }
        }

        return false;
    }

    // generateAttack() uses Random class in java to simulate attacks from 1-6.
    // Using an accessor method to randomize between 1-6 then returning them as an
    // integer each time generateAttack() method is called.
    private int generateAttackOrc() {
        int attackHitOrc = -1;
        Random attackRandom = new Random();
        attackHitOrc = attackRandom.nextInt(6 - 1 + 1) + 1;
        System.out.println("The Orc attack point is " + attackHitOrc);
        return attackHitOrc;
    }

    private int generateAttackDwarf() {
        int attackHitDwarf = -1;
        Random attackRandom = new Random();
        attackHitDwarf = attackRandom.nextInt(6 - 1 + 1) + 1;
        System.out.println("The Dwarf attack point is " + attackHitDwarf);
        return attackHitDwarf;
    }

}