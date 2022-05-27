package KnapSackProblem2;

import java.util.ArrayList;
import java.util.Random;

public class KnapsackRandomSmart {
    private Random random;

    private Problem problem;

    private int objective;

    public KnapsackRandomSmart(Problem problem) {
        this.problem = problem;
        this.random = new Random(problem.getParameters().solverSeed);
    }

    public ArrayList<Item> solveMultiple() {
        System.out.println("Smart Random Multiple");

        ArrayList<Item> best = new ArrayList<>();
        int bestValue = 0;

        for (int i = 0; i < problem.getParameters().randomN; i++) {
            ArrayList<Item> solution = solveSingle();
            int value = calculateObjective(solution);

            if (value > bestValue) {
                best = solution;
                bestValue = value;
            }
        }

        System.out.println("Objective: " + bestValue);
        this.objective = bestValue;

        return best;
    }

    private int calculateObjective(ArrayList<Item> bag) {
        int value = 0;

        for (int i = 0; i < bag.size(); i++) {
            value += bag.get(i).getValue();
        }

        return value;
    }

    public ArrayList<Item> solveSingle() {
        // System.out.println("Smart Random");
        ArrayList<Item> bag = new ArrayList<>();

        int remainingCapacity = problem.getParameters().capacity;
        int value = 0;

        ArrayList<Item> copy = new ArrayList<>();
        copy.addAll(problem.getItems());

        while (!copy.isEmpty()) {
            int index = selectRandom(copy);
            Item candidate = copy.remove(index);

            if (candidate.getWeight() <= remainingCapacity) {
                bag.add(candidate);
                remainingCapacity -= candidate.getWeight();
                value += candidate.getValue();
            }
        }

        // System.out.println("Remaining Capacity: " + remainingCapacity);
        // System.out.println("Objective: " + value);
        // this.objective = value;

        return bag;
    }

    private int selectRandom(ArrayList<Item> remainingItems) {
        double[] probs = calculateProbs(remainingItems);

        double r = random.nextDouble();
        double p = 0;

        for (int i = 0; i < remainingItems.size(); i++) {
            if (p <= r && r < p + probs[i]) {
                return i;
            }

            p += probs[i];
        }

        return remainingItems.size() - 1;
    }

    private double[] calculateProbs(ArrayList<Item> items) {
        double[] probs = new double[items.size()];
        double sum = 0;

        for (int i = 0; i < probs.length; i++) {
            Item item = items.get(i);

            probs[i] = (double) item.getValue() / item.getWeight();
            sum += probs[i];
        }

        for (int i = 0; i < probs.length; i++) {
            probs[i] = probs[i] / sum;
        }

        return probs;
    }
}
