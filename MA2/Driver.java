// public class Driver that is the main driver and runs a main() method that states the default values of 
// Adventurer class and names a new player called Balin with 15 health through Adventurer class method gainLevel().
public class Driver {
    public static void main(String[] args) {
        Adventurer myAdventure = new Adventurer();
        System.out.println(
                "the default values for name is " + myAdventure.name + " and health is " + myAdventure.getHealth());
        Adventurer player = new Adventurer();
        player.name = "Balin";
        player.setHealth(10);
        player.gainLevel();
        System.out.println("The new values for name is " + player.name + " and health is " + player.getHealth());

        Adventurer calcifer = new Adventurer(30, "Calcifer");
    }
}
