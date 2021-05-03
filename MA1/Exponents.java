import java.util.Scanner;
// importing Scanner class from java utilities

// public class Exponents is instantiated
public class Exponents {

    // main function contains body of proram and is passed in String class array as
    // arguement
    public static void main(String[] args) {

        System.out.println("Enter your base number: ");
        Scanner baseInput = new Scanner(System.in);
        int base = baseInput.nextInt();
        System.out.println("Enter your power?: ");
        Scanner powerInput = new Scanner(System.in);
        int power = powerInput.nextInt();

        // exponent value tracker deafault is value one
        int exponent = 1;

        // for loop steps through multiplying base to the limit of power and updates the
        // value to exponent variable
        for (int i = 1; i <= power; i++) {

            exponent = exponent * base;
        }
        // result of the base to the power is displayed back
        System.out.println("Result of base " + base + " to the exponent " + power + " is " + exponent);
    }

}