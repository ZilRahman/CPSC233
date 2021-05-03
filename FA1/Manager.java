// The Fight Simulator 3000 program implements a text based simulation program that inputs a number
// of rounds from the user and outputs a simulation of each round and end of simulation report

import java.util.Scanner;
// import Scanner class into manager for input of rounds from user

public class Manager {
    public static void main(String[] args) {
        // prints statements on welcome and rules as well as,
        // input from user on number of rounds they wish to simulate.
        System.out.println("Welcome to Fight Simulator 3000");
        System.out.println("Enter rounds from one to one-hundred max, if outside range default ten rounds will run.");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter number of rounds: ");

        // stores input value in integer.
        int roundNumber = userInput.nextInt();

        // instantiates an Attacker class object & a Defender class object to be used
        // later in the program.
        Attacker bruce = new Attacker();
        Defender jackie = new Defender();

        // all six integer variables are used simultaneously in program to calculate
        // percetage of Attacker &
        // Defender values to determine hits and blocks.
        int offense;
        int defense;

        int blockNumber;
        int hitNumber;

        int blockFinal;
        int hitFinal;

        // blockNumber and hitNumber variables used to keep a tally on attacks/blocks.
        blockNumber = 0;
        hitNumber = 0;

        // condition if rounds do not meet program criteria then ten simulations/rounds
        // will run
        if (roundNumber > 100 || roundNumber <= 0) {
            // statement telling user ten rounds will run by default.
            System.out.println(" ");
            System.out.print("round number outside of given range, program will run ten rounds by default.");
            System.out.println(" ");

            // for loop that steps through and calls Attacker/Defense class objects to run
            // simulation and determine if it was a 'block' or 'hit' using a if else
            // statement
            for (int i = 0; i <= 10; i++) {
                System.out.println(" ");
                System.out.println("round number: " + i);
                offense = bruce.generateAttack();
                defense = jackie.generateDefense();

                if (offense == defense) {
                    System.out.println("BLOCKED!");
                    blockNumber++;
                    System.out.println(" ");
                } else {
                    System.out.print("HIT");
                    hitNumber++;
                    System.out.println(" ");
                }

                // final percentage of blocks or hits calculated
                blockFinal = (blockNumber * 100 / roundNumber);
                hitFinal = (hitNumber * 100 / roundNumber);

                // end of simulation report given at the end of the program showing percentage
                // results
                // of hits vs blocks.
                System.out.println(" ");
                System.out.print("End of simulations Report: " + blockFinal + "% of blocks and " + hitFinal
                        + "% of hits in ten number of rounds.");
                System.out.println(" ");
            }
        }

        // condition if rounds meet given criteria of program then said number of rounds
        // will run
        else {
            // statement telling user their desired number of rounds will run.
            System.out.println(" ");
            System.out.println("simulator is running " + roundNumber + " number of rounds.");
            System.out.println(" ");

            // for loop that steps through and calls Attacker/Defense class objects to run
            // simulation and determine if it was a 'block' or 'hit' using a if else
            // statement
            for (int i = 0; i <= roundNumber; i++) {
                System.out.println(" ");
                System.out.println("round number: " + i);
                offense = bruce.generateAttack();
                defense = jackie.generateDefense();
                if (offense == defense) {
                    System.out.println("BLOCKED!");
                    blockNumber++;
                    System.out.println(" ");
                } else {
                    System.out.print("HIT");
                    hitNumber++;
                    System.out.println(" ");
                }

            }
            // final percentage of blocks or hits calculated
            blockFinal = (blockNumber * 100 / roundNumber);
            hitFinal = (hitNumber * 100 / roundNumber);

            // end of simulation report given at the end of the program showing percentage
            // results
            // of hits vs blocks.
            System.out.println(" ");
            System.out.print("End of simulations Report: " + blockFinal + "% of blocks and " + hitFinal
                    + "% of hits in " + roundNumber + " number of rounds.");
            System.out.println(" ");
        }

    }
}