package week5;

import java.util.ArrayList;
import java.util.Random;

public class Begum {
    public static void main(String[] args) {
        System.out.println(untilTails(5));
    }

    public static int untilTails(int n) {
        Random random = new Random();

        ArrayList<Coin> coins = new ArrayList<>();
        int tailCounter = 0;

        while (tailCounter < n) {
            Coin coin = new Coin(random);

            if (coin.isTail) {
                tailCounter += 1;
            }

            coins.add(coin);
        }

        for (Coin coin : coins) {
            System.out.println(coin.isTail);
        }

        return coins.size();
    }
}
