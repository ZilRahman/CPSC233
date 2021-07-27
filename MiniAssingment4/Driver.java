public class Driver {

    public static void main(String[] args) {
        Animal anAnimal = new Animal();
        anAnimal.walk();
        System.out.println(anAnimal.toString());
        Bird aBird = new Bird();
        System.out.println(aBird); // Display initial state (two attributes)
        aBird.fly(); // Reduce energy by the specified amount, display message
        aBird.walk(); // Reduce energy by the specified amount, display message
        System.out.println(aBird); // Display new state (two attributes)
    }
}
