import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {

        Entity[][] myEntityArray = FileInitialization.read();
        World myWorld = new World(myEntityArray);
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to continue the simulation? (y/n): ");

        String userDecision = in.nextLine();

        while (!userDecision.equals("n")) {
            myWorld.displayWorld();
            myWorld.traverseWorld();
            myWorld.displayWorld();
            in.nextLine();
        }

        // if (userDecision.equals("y")) {
        // // continue the simulation
        // System.out.println("yes works");
        // myWorld.displayWorld();
        // myWorld.traverseWorld();
        // myWorld.displayWorld();
        // in.nextLine();
        // }

        // else if (userDecision.equals("n")) {
        // // end simulation
        // System.out.println("no works");
        // }

        // else if (!userDecision.equals("y") || !userDecision.equals("n")) {
        // // not the right selection
        // System.out.println("Not the right selection! Please enter either yes(y) or
        // no(n).");
        // in.nextLine();
        // }

        in.close();
    }
}
