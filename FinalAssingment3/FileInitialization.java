import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileInitialization {

    private static final int SIZE = 10;

    public static Entity[][] read() {
        Entity[][] MyEntityArray = new Entity[SIZE][SIZE];
        // Read from file and put entity in right place.

        try {
            File dataFile = new File("data.txt");
            Scanner myReader = new Scanner(dataFile);

            int rowNumber = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] newElements = line.split(" ");
                for (int i = 0; i < SIZE; i++) {
                    if (newElements[i].equals("O")) {
                        // Make O entity
                        // System.out.println("O at" + rowNumber + " " + i);
                        Entity Orc = new Entity("O", 10);
                        MyEntityArray[rowNumber][i] = Orc;
                    } else if (newElements[i].equals("D")) {
                        // Make D entity
                        // System.out.println("D at" + rowNumber + " " + i);
                        Entity Dwarf = new Entity("D", 15);
                        MyEntityArray[rowNumber][i] = Dwarf;
                    }
                }

                // System.out.println("Line num " + rowNumber);
                rowNumber++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getStackTrace());
        }

        // Instantite each entity

        return MyEntityArray;
    }
}