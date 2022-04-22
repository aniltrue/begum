package week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GreedyKnapsack {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(10, 5));
        items.add(new Item(8, 4));
        items.add(new Item(7, 11));
        items.add(new Item(12, 3));
        items.add(new Item(4, 2));
        items.add(new Item(18, 20));

        Knapsack knapsack = new Knapsack(20);

        greedy1(knapsack, items);

        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());

        knapsack.items.clear();

        greedy2(knapsack, items);

        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());

        knapsack.items.clear();

        greedy3(knapsack, items);

        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());
    }

    public static void greedy1(Knapsack knapsack, ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (knapsack.getTotalWeight() + item.getWeight() <= knapsack.getCapacity()) {
                knapsack.items.add(item);
            }
        }
    }

    public static void greedy2(Knapsack knapsack, ArrayList<Item> items) {
        Collections.sort(items, Comparator.comparingDouble(Item::getValue));
        Collections.reverse(items);

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (knapsack.getTotalWeight() + item.getWeight() <= knapsack.getCapacity()) {
                knapsack.items.add(item);
            }
        }
    }

    public static void greedy3(Knapsack knapsack, ArrayList<Item> items) {
        Collections.sort(items, Comparator.comparingDouble(item -> item.getValue() / item.getWeight()));
        Collections.reverse(items);

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (knapsack.getTotalWeight() + item.getWeight() <= knapsack.getCapacity()) {
                knapsack.items.add(item);
            }
        }
    }

    public static double getRatio(Item item) {
        return item.getValue() / item.getWeight();
    }
}
