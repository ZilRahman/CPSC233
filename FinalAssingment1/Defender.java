
// Defender class of Fight Simulator program uses Random class in java to simulate
// attacks from 1(high defense) 2(medium defense) and 3(low defense). Using an accessor
// method to randomize between one, two and three then returning them as an integer
// each time Defender class is called. 
import java.util.Random;

public class Defender {

    public int generateDefense() {
        int defenseHit = -1;
        Random defenseRandom = new Random();
        defenseHit = defenseRandom.nextInt(3 - 1 + 1) + 1;
        if (defenseHit == 1) {
            System.out.println("High Defense!");
        } else if (defenseHit == 2) {
            System.out.println("Medium Defense!");
        } else {
            System.out.println("Low Defense!");
        }
        return defenseHit;
    }

}