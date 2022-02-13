package knapsack.p2;

public class Item {
    private int id;

    private double weight, value, volume;

    public Item(int id, double weight, double value, double volume) {
        this.id = id;
        this.weight = weight;
        this.value = value;
        this.volume = volume;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public double getVolume() {
        return volume;
    }
}
