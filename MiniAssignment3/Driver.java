import java.util.Scanner;

// Class Driver is responsible for running the code amd getting user input then calling appropriate 
// method from World class and displaying the 2d array.
public class Driver {
    public static void main(String[] args) {
        World earth = new World();
        System.out.println("\nMaking an entity......");
        earth.getAppearance();
        System.out.println("\n ");

        System.out.println("Destination row (0-5): ");
        Scanner userInputRow = new Scanner(System.in);

        int rowNumber = userInputRow.nextInt();

        System.out.println("Destination column (0-5): ");
        Scanner userInputColumn = new Scanner(System.in);

        int columnNumber = userInputColumn.nextInt();

        if (rowNumber > 5 || columnNumber > 5) {
            System.out.println("row/column: " + rowNumber + "/" + columnNumber + " out of bounds!");

        }

        earth.move(rowNumber, columnNumber);
        earth.printWorld();

    }
}
