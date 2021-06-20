public class Entity {
    private String appearance;
    private int hitPoint;

    public Entity() {
        this.appearance = "E";
        this.hitPoint = 0;
    }

    public Entity(String appearance, int hitPoint) {
        this.appearance = appearance;
        this.hitPoint = hitPoint;
    }

    public String getAppearance() {
        return appearance;
    }

    public int getHitPoint() {
        return hitPoint;
    }
}
