public class Simulator {

    public static void main(String[] args) {

        Entity[][] myEntityArray = FileInitialization.read();
        World myWorld = new World(myEntityArray);
    }
}
