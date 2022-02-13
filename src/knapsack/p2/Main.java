package knapsack.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> solve(HashMap<Integer, Double> weights, HashMap<Integer, Double> values, double capacity) {
        ArrayList<Integer> keys = new ArrayList<>();

        for (Integer key : values.keySet()) {
            keys.add(key);
        }

        Collections.sort(keys, Comparator.comparingDouble(values::get)); // p -> values.get(p)
        Collections.reverse(keys);

        ArrayList<Integer> knapsack = new ArrayList<>();

        double remaining = capacity;
        double value = 0;

        for (Integer key : keys) {
            if (weights.get(key) <= remaining) {
                knapsack.add(key);
                remaining -= weights.get(key);
                value += values.get(key);
            }
        }

        System.out.println(value);

        return knapsack;
    }

    public static Bag solve(ArrayList<Item> items, double capacityWeight, double capacityVolume) {
        Bag bag = new Bag(capacityVolume, capacityWeight);

        Collections.sort(items, Comparator.comparingDouble(Item::getValue));
        Collections.reverse(items);

        double remainingWeight = capacityWeight;
        double remainingVolume = capacityVolume;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= remainingWeight && items.get(i).getVolume() <= remainingVolume) {
                bag.getItems().add(items.get(i));
                remainingWeight -= items.get(i).getWeight();
                remainingVolume -= items.get(i).getVolume();
            }
        }

        return bag;
    }
}
