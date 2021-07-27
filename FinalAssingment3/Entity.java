public class Entity {
    private String appearance;
    private int health;

    public Entity() {
        this.appearance = "E";
        this.health = 0;
    }

    public Entity(String appearance, int health) {
        this.appearance = appearance;
        this.health = health;
    }

    public String getAppearance() {
        return appearance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
