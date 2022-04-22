package week7;

public class Item {
    private static int COUNTER = 0;
    private double weight, value;
    private int id;

    public Item(double value, double weight) {
        this.weight = weight;
        this.value = value;
        this.id = COUNTER++;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
