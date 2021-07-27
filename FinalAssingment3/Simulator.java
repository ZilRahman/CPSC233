import java.util.Scanner;

// main execution point of the program, calls upon World class via a World object
// and traverses world in a round-by-round fashion asking the user's input each round.
public class Simulator {

    public static void main(String[] args) {

        Entity[][] myEntityArray = FileInitialization.read();
        World myWorld = new World(myEntityArray);
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to continue the simulation? (y/n): ");

        String userDecision = in.nextLine();

        while (!userDecision.equals("n")) {

            myWorld.traverseWorld();
            System.out.println();
            System.out.println("Would you like to continue the simulation? (y/n): ");
            in.nextLine();

            if (userDecision.equals("n")) {
                // end simulation
                System.out.println("no works");
            }
        }

        in.close();
    }
}
