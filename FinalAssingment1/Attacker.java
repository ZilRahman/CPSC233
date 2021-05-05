// Attacker class of Fight Simulator program uses Random class in java to simulate
// attacks from 1(high attack) 2(medium attack) and 3(low attack). Using an accessor
// method to randomize between one, two and three then returning them as an integer
// each time Attacker class is called. 

import java.util.Random;

public class Attacker {

    public int generateAttack() {
        int attackHit = -1;
        Random attackRandom = new Random();
        attackHit = attackRandom.nextInt(3 - 1 + 1) + 1;
        if (attackHit == 1) {
            System.out.println("High Attack!");
        } else if (attackHit == 2) {
            System.out.println("Medium Attack!");
        } else {
            System.out.println("Low Attack!");
        }
        return attackHit;
    }

}
