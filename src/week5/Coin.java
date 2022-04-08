package week5;

import java.util.Random;

public class Coin {
    public boolean isTail;

    public Coin(Random random) {
        if (random.nextDouble() < 0.5) {
            isTail = true;
        } else {
            isTail = false;
        }
    }
}
