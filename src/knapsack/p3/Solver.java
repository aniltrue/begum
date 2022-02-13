package knapsack.p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
    public static Knapsack solve(int[] weights, int[] values, int capacity) {
        Knapsack knapsack = new Knapsack(weights, values, capacity);

        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            order.add(i);
        }

        Collections.sort(order, Comparator.comparingInt(p -> values[p]));
        Collections.reverse(order);

        for (int i = 0; i < order.size(); i++) {
            int index = order.get(i);

            if (weights[i] + knapsack.totalWeight() <= capacity) {
                knapsack.getX()[index] = 1;
            }
        }

        return knapsack;
    }
}
