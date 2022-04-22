package week7;

import java.util.*;

public class RandomKnapsack {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(10, 5));
        items.add(new Item(8, 4));
        items.add(new Item(7, 11));
        items.add(new Item(12, 3));
        items.add(new Item(4, 2));
        items.add(new Item(18, 20));
        items.add(new Item(9, 6));
        items.add(new Item(8, 12));
        items.add(new Item(6, 5));
        items.add(new Item(4, 6));

        Knapsack knapsack = new Knapsack(20);

        random1(knapsack, items);

        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());

        knapsack.items.clear();

        random1(knapsack, items);

        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());

        knapsack = random2(items, 20, 10);

        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());

        knapsack.items.clear();

        random3(knapsack, items);

        System.out.println();
        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());

        knapsack = random4(items, 20, 10);

        System.out.println();
        System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());
    }

    public static void random1(Knapsack knapsack, ArrayList<Item> items) {
        Random random = new Random();

        ArrayList<Item> copy = new ArrayList<>();
        copy.addAll(items);

        // [4, 2, 1]
        while (copy.size() > 0) {
            int index = random.nextInt(copy.size());

            Item item = copy.remove(index);

            if (knapsack.getTotalWeight() + item.getWeight() <= knapsack.getCapacity()) {
                knapsack.items.add(item);
            }
        }
    }

    public static Knapsack random2(ArrayList<Item> items, double capacity, int n) {
        ArrayList<Knapsack> knapsacks = new ArrayList<>();

        System.out.println();

        for (int i = 0; i < n; i++) {
            Knapsack knapsack = new Knapsack(capacity);

            random1(knapsack, items);

            knapsacks.add(knapsack);

            System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());
        }

        System.out.println();

        Collections.sort(knapsacks, Comparator.comparingDouble(Knapsack::getTotalValue));

        return knapsacks.get(n - 1);
    }

    public static void random3(Knapsack knapsack, ArrayList<Item> items) {
        Random random = new Random();

        ArrayList<Item> copy = new ArrayList<>();
        copy.addAll(items);

        // [4, 2, 1]
        while (copy.size() > 0) {
            int index = smartChoose(random, copy);

            Item item = copy.remove(index);

            if (knapsack.getTotalWeight() + item.getWeight() <= knapsack.getCapacity()) {
                knapsack.items.add(item);
            }
        }
    }

    public static Knapsack random4(ArrayList<Item> items, double capacity, int n) {
        ArrayList<Knapsack> knapsacks = new ArrayList<>();

        System.out.println();

        for (int i = 0; i < n; i++) {
            Knapsack knapsack = new Knapsack(capacity);

            random3(knapsack, items);

            knapsacks.add(knapsack);

            System.out.println(knapsack.items + ": " + knapsack.getTotalValue() + " - " + knapsack.getTotalWeight());
        }

        System.out.println();

        Collections.sort(knapsacks, Comparator.comparingDouble(Knapsack::getTotalValue));

        return knapsacks.get(n - 1);
    }

    private static Integer smartChoose(Random random, ArrayList<Item> items) {
        HashMap<Integer, Double> probs = getProb(items);

        double p = 0;
        double r = random.nextDouble();

        for (Integer key : probs.keySet()) {
            if (p <= r && r < p + probs.get(key)) {
                return key;
            }

            p += probs.get(key);
        }

        return -1;
    }

    private static HashMap<Integer, Double> getProb(ArrayList<Item> items) {
        HashMap<Integer, Double> probs = new HashMap<>();

        double sum = 0;

        for (int i = 0; i < items.size(); i++) {
            double value = items.get(i).getValue() / items.get(i).getWeight();

            sum += value;
            probs.put(i, value);
        }

        for (Integer key : probs.keySet()) {
            probs.replace(key, probs.get(key) / sum);
        }

        return probs;
    }
}
