/**
 * Entity class. Contains an appeareance attribute.
 */
public class Entity {

    private String appearance;

    public Entity() {
        appearance = "X";
    }

    public Entity(String appearance) {
        this.appearance = appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getAppearance() {
        return appearance;
    }

    @Override
    public String toString() {
        return this.appearance;
    }
}