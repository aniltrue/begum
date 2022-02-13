package knapsack.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Item: Value, Weight
        // Knapsack: Capacity
        // Itemlerin toplam value'sü maximum
        // Itemlerin toplam weight'i capacity'den küçük veya eşit

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1, 10., 5.));
        items.add(new Item(2, 1., 1.));
        items.add(new Item(3, 10., 15.));
        items.add(new Item(4, 5., 5.));
        items.add(new Item(5, 6., 7.));
        items.add(new Item(6, 10., 7.));
        items.add(new Item(7, 3., 7.));
        items.add(new Item(8, 3., 2.));
        items.add(new Item(9, 12., 8.));

        Knapsack knapsack = new Knapsack(25.);

        knapsack.print();

        solve(knapsack, items);

        knapsack.print();
        System.out.println(knapsack.isFeasible());

        solve2(items, 25).print();
        solve3(items, 25).print();
        solve4(items, 25).print();
        solve5(items, 25).print();
        solve6(items, 25).print();
    }

    public static void solve(Knapsack knapsack, ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= knapsack.getRemaining())
                knapsack.add(items.get(i));
        }
    }

    public static Knapsack solve(ArrayList<Item> items, double capacity) {
        Knapsack knapsack = new Knapsack(capacity);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= knapsack.getRemaining())
                knapsack.add(items.get(i));
        }

        return knapsack;
    }

    public static Knapsack solve2(ArrayList<Item> items, double capacity) {
        Knapsack knapsack = new Knapsack(capacity);

        Collections.sort(items, Comparator.comparingDouble(Item::getWeight));

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= knapsack.getRemaining())
                knapsack.add(items.get(i));
        }

        return knapsack;
    }

    public static Knapsack solve3(ArrayList<Item> items, double capacity) {
        Knapsack knapsack = new Knapsack(capacity);

        Collections.sort(items, Comparator.comparingDouble(Item::getValue)); // p -> p.getValue
        Collections.reverse(items);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= knapsack.getRemaining())
                knapsack.add(items.get(i));
        }

        return knapsack;
    }

    public static Knapsack solve4(ArrayList<Item> items, double capacity) {
        Knapsack knapsack = new Knapsack(capacity);

        // value / weight
        Collections.sort(items, Comparator.comparingDouble(Item::getPoint));
        Collections.sort(items, Comparator.comparingDouble(p -> p.getValue() / p.getWeight()));
        Collections.reverse(items);

        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).getId() + " ");
        }

        System.out.println();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= knapsack.getRemaining())
                knapsack.add(items.get(i));
        }

        return knapsack;
    }

    public static Knapsack solve5(ArrayList<Item> items, double capacity) {
        Knapsack knapsack = new Knapsack(capacity);
        Random rnd = new Random();

        for (int i = 0; i < items.size(); i++) {
            // [0, 0.5) Ekle, [0.5, 1) Ekleme
            if (items.get(i).getWeight() <= knapsack.getRemaining() && rnd.nextDouble() < 0.5)
                knapsack.add(items.get(i));
        }

        return knapsack;
    }

    public static Knapsack solve6(ArrayList<Item> items, double capacity) {
        Knapsack knapsack = new Knapsack(capacity);
        Random rnd = new Random();

        Collections.shuffle(items);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getWeight() <= knapsack.getRemaining())
                knapsack.add(items.get(i));
        }

        return knapsack;
    }
}
