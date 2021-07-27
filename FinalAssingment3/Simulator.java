import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {

        Entity[][] myEntityArray = FileInitialization.read();
        World myWorld = new World(myEntityArray);
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to continue the simulation? (y/n): ");

        String userDecision = in.nextLine();

        while (!userDecision.equals("n")) {

            myWorld.traverseWorld();

            in.nextLine();

            if (userDecision.equals("n")) {
                // end simulation
                System.out.println("no works");
            }
        }

        in.close();
    }
}
