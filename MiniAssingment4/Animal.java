public class Animal {
    protected int energy;

    public Animal() {
        this.energy = 20;
    }

    /**
     * Lets animal walk and use energy points.
     */
    public void walk() {
        this.energy = this.energy - 2;
        System.out.println("Walking like an animal!");
    }

    /**
     * Basic toString implementation
     */
    public String toString() {
        return "Hi, I am an animal, my energy level is:" + this.energy;
    }
}