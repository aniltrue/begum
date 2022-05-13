package KnapSackProblem;

import java.util.ArrayList;
import java.util.Random;

public class KnapsackRandom {
    private Random random;

    private Problem problem;

    private int objective;

    public KnapsackRandom(Problem problem) {
        this.problem = problem;
        this.random = new Random(problem.getParameters().solverSeed);
    }

    public ArrayList<Item> solveMultiple() {
        System.out.println("Random Multiple");

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
        // System.out.println("Random Single");
        ArrayList<Item> bag = new ArrayList<>();

        ArrayList<Item> copy = new ArrayList<>();
        copy.addAll(problem.getItems());

        int remainingCapacity = problem.getParameters().capacity;
        int value = 0;

        while (!copy.isEmpty()) {
            int index = random.nextInt(copy.size());
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

    public int getObjective() {
        return objective;
    }
}
