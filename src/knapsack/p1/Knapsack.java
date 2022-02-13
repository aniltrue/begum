package knapsack.p1;

import java.util.ArrayList;

public class Knapsack {
    private double capacity;
    private ArrayList<Item> items = new ArrayList<>(); // İçindekiler listesi

    public Knapsack(double capacity) {
        this.capacity = capacity;
    }

    public void add(Item item) {
        items.add(item);
    }

    public double getRemaining() {
        double sum = 0.;

        for (int i = 0; i < items.size(); i++) {
            sum += items.get(i).getWeight();
        }

        return capacity - sum;
    }

    public double getTotalValue() {
        double sum = 0.;

        for (int i = 0; i < items.size(); i++) {
            sum += items.get(i).getValue();
        }

        return sum;
    }

    public void print() {
        System.out.print("[");

        for (int i = 0; i < items.size(); i++) {
            if (i == items.size() - 1)
                System.out.print(items.get(i).getId());
            else
                System.out.print(items.get(i).getId() + ", ");
        }

        System.out.println("]: " + getTotalValue() + ", " + getRemaining());
    }

    public boolean isFeasible() {
        return getRemaining() >= 0;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getCapacity() {
        return capacity;
    }
}
