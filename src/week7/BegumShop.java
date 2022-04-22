package week7;

import java.util.HashMap;
import java.util.Random;

public class BegumShop {
    public static void main(String[] args) {
        HashMap<String, Double> customerTypes = new HashMap<>();

        customerTypes.put("Kadın", 0.4);
        customerTypes.put("Erkek", 0.3);
        customerTypes.put("Öğrenci", 0.3);

        HashMap<String, Double> sellingMean = new HashMap<>();
        sellingMean.put("Kadın", 10.0);
        sellingMean.put("Erkek", 8.0);
        sellingMean.put("Öğrenci", 5.0);

        HashMap<String, Double> sellingStd = new HashMap<>();
        sellingStd.put("Kadın", 3.0);
        sellingStd.put("Erkek", 2.5);
        sellingStd.put("Öğrenci", 2.0);

        System.out.println(experiment2(customerTypes, sellingMean, sellingStd, 120, 100));
    }

    public static double experiment(HashMap<String, Double> customerTypes, HashMap<String, Double> selling, int seed, int n) {
        RandomGenerator randomGenerator = new RandomGenerator(seed);

        double total = 0;

        for (int i = 0; i < n; i++) {
            double p = customerTypes.get("Kadın");

            if (randomGenerator.determine(p)) {
                total += selling.get("Kadın");
            } else {
                total += selling.get("Erkek");
            }
        }

        return total;
    }

    public static double experiment2(HashMap<String, Double> customerTypes, HashMap<String, Double> sellingMean, HashMap<String, Double> sellingStd, int seed, int n) {
        RandomGenerator randomGenerator = new RandomGenerator(seed);

        HashMap<String, Double> probs = new HashMap<>();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String customerType = randomGenerator.determine(customerTypes);

            total += randomGenerator.nextGauss(sellingMean.get(customerType), sellingStd.get(customerType));

            if (!probs.containsKey(customerType)) {
                probs.put(customerType, 0.0);
            }

            probs.replace(customerType, probs.get(customerType) + 1);
        }

        for (String key : probs.keySet()) {
            probs.replace(key, probs.get(key) / n);
        }

        System.out.println(probs);

        return total;
    }
}
