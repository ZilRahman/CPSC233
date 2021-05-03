// public class Adventurer that has a constructor whose default values are name: nameless and health: -1
// method in class gainlevel() that prints "congratulations" and increases health by 5
public class Adventurer {
    private int health;
    String name;

    public Adventurer() {
        name = "nameless";
        health = -1;
    }

    public Adventurer(int newHealth, String newName) {
        health = newHealth;
        name = newName;
    }

    public void gainLevel() {
        String lvlUp = "Level-Up......Congratulations!";
        System.out.println(lvlUp);
        health = health + 5;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }
}