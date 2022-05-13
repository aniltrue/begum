package KnapSackProblem;

import java.util.ArrayList;
import java.util.Random;

public class Problem {
    private Random random;

    private Parameters parameters;

    private ArrayList<Item> items = new ArrayList<>();

    public Problem(Parameters parameters) {
        this.parameters = parameters;
        this.random = new Random(parameters.seed);

        generateRandomItems();
    }

    public void generateRandomItems() {
        items.clear();

        for (int i = 0; i < parameters.numberOfItems; i++) {
            generateRandomItem();
        }
    }

    private void generateRandomItem() {
        // [l, u)
        int value = random.nextInt(parameters.maxValue + 1 - parameters.minValue) + parameters.minValue;
        int weight = random.nextInt(parameters.maxWeight + 1 - parameters.minWeight) + parameters.minWeight;

        Item item = new Item(weight, value);
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Parameters getParameters() {
        return parameters;
    }
}
