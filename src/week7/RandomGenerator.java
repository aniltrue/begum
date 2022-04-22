package week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomGenerator {
    private Random random;
    private int seed;

    public RandomGenerator(int seed) {
        this.seed = seed;
        random = new Random(seed);
        // random.setSeed(seed);
    }

    public void setSeed(int seed) {
        this.seed = seed;
        random.setSeed(seed);
    }

    public int getSeed() {
        return seed;
    }

    public void ali() {
        seed += 1;
        random.setSeed(seed);
    }

    public double nextDouble() {
        return random.nextDouble();
    }

    public int nextInt(int lower, int upper) { // [0, n) -> [0, u - l + 1) -> [l, u + 1) = [l, u]
        return random.nextInt(upper - lower + 1) + lower;
    }

    public double nextDouble(double lower, double upper) { // [0, 1) -> [0, u - l) -> [l, u)
        // [0, u - l) + l = [l, u)
        return random.nextDouble() * (upper - lower) + lower;
    }

    public int rollDie() {
        // return random.nextInt(6) + 1;
        return nextInt(1, 6);
    }

    public int randomChoose(ArrayList<Integer> arr) {
        return random.nextInt(arr.size()); // [0, n)
        // return arr.get(random.nextInt(arr.size()));
    }

    public int randomChoose(int[] arr) {
        return random.nextInt(arr.length);
    }

    public boolean determine(double p) { // p: 0.1
        double r = random.nextDouble();

        if (r < p)
            return true;

        return false;
    }

    public String determine(HashMap<String, Double> probs) {
        double p = 0;

        double r = random.nextDouble();

        for (String key : probs.keySet()) {
            if (p <= r && r < p + probs.get(key)) {
                return key;
            }

            p += probs.get(key);
        }

        return ""; // Never touch!
    }

    public double nextGauss(double mean, double std) {
        // N(0, 1) * std + mean -> N(mean, std)
        return random.nextGaussian() * std + mean;
    }
}
