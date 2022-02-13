package knapsack.p2;

import java.util.ArrayList;

public class Bag {
    private ArrayList<Item> items = new ArrayList<>();

    private double capacityWeight, capacityVolume;

    public Bag(double capacityVolume, double capacityWeight) {
        this.capacityVolume = capacityVolume;
        this.capacityWeight = capacityWeight;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getCapacityVolume() {
        return capacityVolume;
    }

    public double getCapacityWeight() {
        return capacityWeight;
    }
}
