package KnapSackProblem;

public class Item {
    private int weight, value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public double getHeuristic() {
        return (double) getValue() / getWeight();
    }
}
