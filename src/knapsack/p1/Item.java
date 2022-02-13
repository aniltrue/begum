package knapsack.p1;

public class Item {
    private int id;
    private double weight, value;

    public Item(int id, double weight, double value) {
        this.id = id;
        this.weight = weight;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public double getPoint() {
        return value / weight;
    }
}
