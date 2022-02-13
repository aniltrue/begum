package knapsack.p3;

public class Knapsack {
    private int[] X, values, weights;
    private int capacity;

    public Knapsack(int[] weights, int[] values, int capacity) {
        this.capacity = capacity;
        this.X = new int[weights.length]; // 0, 0, 0, 0, 0
        this.weights = weights;
        this.values = values;
    }

    public int totalWeight() {
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += X[i] * weights[i];
        }

        return sum;
    }

    public boolean checkConstraint() { // E X[i] * w[i] <= c
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += X[i] * weights[i];
        }

        return sum <= capacity;
    }

    public int getObjective() { // E X[i] * v[i]
        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            sum += X[i] * values[i];
        }

        return sum;
    }

    public int[] getX() {
        return X;
    }
}
