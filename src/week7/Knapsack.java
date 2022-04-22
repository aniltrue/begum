package week7;

import java.util.ArrayList;

public class Knapsack {
    public ArrayList<Item> items;

    private double capacity;

    public Knapsack(double capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public double getTotalValue() {
        double total = 0;

        for (Item item : items) {
            total += item.getValue();
        }

        return total;
    }

    public double getTotalWeight() {
        double total = 0;

        for (Item item : items) {
            total += item.getWeight();
        }

        return total;
    }

    public double getCapacity() {
        return capacity;
    }
}
