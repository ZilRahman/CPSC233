// child class Bird for mini-assignment 4
public class Bird extends Animal {
    private int range = 400;

    public void walk() {
        System.out.println("Walking like a bird!");
        energy = energy - 3;
    }

    public void fly() {
        System.out.println(" CAW CAW CAW (flying) *wing-flap noises ensue*");

        energy = energy - 2;
    }

    public String toString() {
        return super.toString() + "\n" + "I'm a bird.";
    }
}
