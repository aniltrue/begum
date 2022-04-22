package week7;

import java.util.HashMap;

public class DieSum {
    public static void main(String[] args) {
        RandomGenerator randomGenerator = new RandomGenerator(121);

        HashMap<Integer, Double> mathProbs = mathematical();
        printProbs(mathProbs);

        HashMap<Integer, Double> expProbs = experimental(randomGenerator, 1000000);
        printProbs(expProbs);
    }

    public static HashMap<Integer, Double> mathematical() {
        HashMap<Integer, Double> probs = new HashMap<>();

        int counter = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                int sum = i + j;
                // {2: 1, 3: 2}
                if (!probs.containsKey(sum)) {
                    probs.put(sum, 0.0);
                }

                probs.replace(sum, probs.get(sum) + 1);
                counter++;
            }
        }

        // {2: 1 / 36, 3: 2 / 36, 4: 3 / 36, ...
        for (Integer key : probs.keySet()) {
            probs.replace(key, probs.get(key) / counter);
        }

        return probs;
    }

    public static HashMap<Integer, Double> experimental(RandomGenerator random, int n) {
        HashMap<Integer, Double> probs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int die1 = random.rollDie();
            int die2 = random.rollDie();

            int sum = die1 + die2;

            if (!probs.containsKey(sum)) {
                probs.put(sum, 0.0);
            }

            probs.replace(sum, probs.get(sum) + 1);
        }

        for (Integer key : probs.keySet()) {
            probs.replace(key, probs.get(key) / n);
        }

        return probs;
    }

    public static void printProbs(HashMap<Integer, Double> probs) {
        for (Integer key : probs.keySet()) {
            System.out.println(key + ": " + probs.get(key) * 100 + "%");
        }
    }
}
