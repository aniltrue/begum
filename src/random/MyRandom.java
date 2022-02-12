package random;

import java.util.*;

public class MyRandom {
    private Random rnd;

    public MyRandom() {
        rnd = new Random();
    }

    public MyRandom(long seed) {
        rnd = new Random(seed);
    }

    public Random getRnd() {
        return rnd;
    }

    public double getDouble(double lowerBound, double upperBound) { // [0, 1) -> [0, 100)
        return lowerBound + rnd.nextDouble() * (upperBound - lowerBound);
        // [0, 1) * 90 -> [0, 90) + 10 -> [10, 100)
        // [0, 1) * 20 -> [0, 20) + (-10) -> [-10, 10)
    }

    public int getInt(int lowerBound, int upperBound) { // [0, u) -> [50, u)
        // [50, 75) = 50 + [0, 25)
        // [-10, +10) = -10 + [0, 20)
        return lowerBound + rnd.nextInt(upperBound - lowerBound);
    }

    public int rollDice() { // 1, 2, 3, 4, 5, 6 // [1, 6] = [1, 7)
        // return getInt(1, 7);
        return 1 + rnd.nextInt(6);
        // 1, 7
    }

    // T, H
    public String roll() {
        // [0, 0.5) : T, [0.5, 1) : H
        if (rnd.nextDouble() < 0.5)
            return "T";
        else
            return "H";
    }

    public String choice(String[] arr) { // Ali, Veli, Ayşe
        int index = rnd.nextInt(arr.length); // [0, n)

        return arr[index];
    }

    public int choice(ArrayList<Integer> arr) {
        int index = rnd.nextInt(arr.size());

        return arr.get(index);
    }

    public void shuffle(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() / 2; i++) {
            int index1 = rnd.nextInt(arr.size());
            int index2 = rnd.nextInt(arr.size());

            int temp = arr.get(index1);
            arr.set(index1, arr.get(index2));
            arr.set(index2, temp);
        }
    }

    public double choice(HashMap<String, Double> map) {
        ArrayList<String> keys = new ArrayList<>();

        for (String key : map.keySet()) {
            keys.add(key);
        }

        int index = rnd.nextInt(keys.size());
        String key = keys.get(index);

        return map.get(key);
    }

    public int choice(int[] arr, double[] probs) { // 1, 2, 3; 0.5, 0.1, 0.4
        // 0.7
        // 1: [0, 0.5)
        // 2: [0.5, 0.6)
        // 3: [0.6, 1)
        double r = rnd.nextDouble();
        double prob = 0.0; // Cumulative Probability

        for (int i = 0; i < arr.length; i++) {
            prob += probs[i];

            if (r < prob)
                return arr[i];
        }

        return arr[arr.length - 1];
    }

    public int mapChoice(HashMap<Integer, Double> map) {
        double r = rnd.nextDouble();
        double prob = 0.0;

        for (Integer key : map.keySet()) {
            prob += map.get(key);

            if (r < prob)
                return key;
        }

        return -1;
    }

    public int choiceMax(int[] arr) { // 1, 2, 3: 1/6, 2/6, 3/6
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double[] probs = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            probs[i] = arr[i] / (double) sum;
        }

        double r = rnd.nextDouble();
        double prob = 0.0;

        for (int i = 0; i < arr.length; i++) {
            prob += probs[i];

            if (r < prob)
                return arr[i];
        }

        return arr[arr.length - 1];
    }

    public int choiceMax2(int[] arr) { // 1, 2, 3: 1/6, 2/6, 3/6
        // e^x / E e^z
        double sum = 0.;

        for (int i = 0; i < arr.length; i++) {
            sum += Math.exp(arr[i]);
        }

        double[] probs = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            probs[i] = Math.exp(arr[i]) / sum;
        }

        double r = rnd.nextDouble();
        double prob = 0.0;

        for (int i = 0; i < arr.length; i++) {
            prob += probs[i];

            if (r < prob)
                return arr[i];
        }

        return arr[arr.length - 1];
    }

    public int choiceMin(int[] arr) { // 1, 2, 3: 1/x: (1/x) / sum
        double sum = 0.;

        for (int i = 0; i < arr.length; i++) {
            sum += 1. / arr[i]; // 1/1 + 1/2 + 1/3
        }

        double[] probs = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            probs[i] = (1. / arr[i]) / sum;
        }

        double r = rnd.nextDouble();
        double prob = 0.0;

        for (int i = 0; i < arr.length; i++) {
            prob += probs[i];

            if (r < prob)
                return arr[i];
        }

        return arr[arr.length - 1];
    }

    public int choiceMin2(int[] arr) { // 1, 2, 3: 1/6, 2/6, 3/6
        // e^x / E e^z
        double sum = 0.;

        for (int i = 0; i < arr.length; i++) {
            sum += Math.exp(-arr[i]);
        }

        double[] probs = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            probs[i] = Math.exp(-arr[i]) / sum;
        }

        double r = rnd.nextDouble();
        double prob = 0.0;

        for (int i = 0; i < arr.length; i++) {
            prob += probs[i];

            if (r < prob)
                return arr[i];
        }

        return arr[arr.length - 1];
    }

    // "A": 100TL // Orta
    // "B": 50TL // En yüksek
    // "C": 200TL // En düşük

    public double calculateRevenue(HashMap<String, Double> customers, int n) {
        HashMap<String, Double> probs = new HashMap<>();

        double sum = 0.;

        for (String key : customers.keySet()) {
            sum += 1. / customers.get(key);
        }

        for (String key : customers.keySet()) {
            probs.put(key, (1. / customers.get(key)) / sum);
        }

        double revenue = 0;

        for (int i = 0; i < n; i++) {
            double r = rnd.nextDouble();
            double prob = 0.0;

            for (String key : probs.keySet()) {
                prob += probs.get(key);

                if (r < prob) {
                    revenue += customers.get(key);
                    break;
                }
            }
        }

        return revenue;
    }
}
