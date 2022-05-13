package KnapSackProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KnapsackGreedy {
    private Problem problem;
    private int objective;

    public KnapsackGreedy(Problem problem) {
        this.problem = problem;
    }

    public ArrayList<Item> solve1() {
        System.out.println("Greedy Solution (v1)");

        ArrayList<Item> bag = new ArrayList<>();

        int remainingCapacity = problem.getParameters().capacity;
        int value = 0;

        for (int i = 0; i < problem.getItems().size(); i++) {
            Item candidate = problem.getItems().get(i);

            if (candidate.getWeight() <= remainingCapacity) {
                bag.add(candidate);
                remainingCapacity -= candidate.getWeight();
                value += candidate.getValue();
            }
        }

        System.out.println("Remaining Capacity: " + remainingCapacity);
        System.out.println("Objective: " + value);
        this.objective = value;

        return bag;
    }

    public ArrayList<Item> solve2() {
        System.out.println("Greedy Solution (v2)");

        ArrayList<Item> copy = new ArrayList<>();
        copy.addAll(problem.getItems());

        Collections.sort(copy, Comparator.comparingInt(Item::getWeight));

        ArrayList<Item> bag = new ArrayList<>();

        int remainingCapacity = problem.getParameters().capacity;
        int value = 0;

        for (int i = 0; i < copy.size(); i++) {
            Item candidate = copy.get(i);

            if (candidate.getWeight() <= remainingCapacity) {
                bag.add(candidate);
                remainingCapacity -= candidate.getWeight();
                value += candidate.getValue();
            }
        }

        System.out.println("Remaining Capacity: " + remainingCapacity);
        System.out.println("Objective: " + value);
        this.objective = value;

        return bag;
    }

    public ArrayList<Item> solve3() {
        System.out.println("Greedy Solution (v3)");

        ArrayList<Item> copy = new ArrayList<>();
        copy.addAll(problem.getItems());

        Collections.sort(copy, Comparator.comparingInt(Item::getValue));
        Collections.reverse(copy);

        ArrayList<Item> bag = new ArrayList<>();

        int remainingCapacity = problem.getParameters().capacity;
        int value = 0;

        for (int i = 0; i < copy.size(); i++) {
            Item candidate = copy.get(i);

            if (candidate.getWeight() <= remainingCapacity) {
                bag.add(candidate);
                remainingCapacity -= candidate.getWeight();
                value += candidate.getValue();
            }
        }

        System.out.println("Remaining Capacity: " + remainingCapacity);
        System.out.println("Objective: " + value);
        this.objective = value;

        return bag;
    }

    public ArrayList<Item> solve4() {
        System.out.println("Greedy Solution (v4)");

        ArrayList<Item> copy = new ArrayList<>();
        copy.addAll(problem.getItems());

        Collections.sort(copy, Comparator.comparingDouble(x -> (double) x.getValue() / x.getWeight()));
        Collections.sort(copy, Comparator.comparingDouble(Item::getHeuristic));
        Collections.sort(copy, Comparator.comparingDouble(KnapsackGreedy::getHeuristic));
        Collections.reverse(copy);

        ArrayList<Item> bag = new ArrayList<>();

        int remainingCapacity = problem.getParameters().capacity;
        int value = 0;

        for (int i = 0; i < copy.size(); i++) {
            Item candidate = copy.get(i);

            if (candidate.getWeight() <= remainingCapacity) {
                bag.add(candidate);
                remainingCapacity -= candidate.getWeight();
                value += candidate.getValue();
            }
        }

        System.out.println("Remaining Capacity: " + remainingCapacity);
        System.out.println("Objective: " + value);
        this.objective = value;

        return bag;
    }

    public static double getHeuristic(Item item) {
        return (double) item.getValue() / item.getWeight();
    }

    public int getObjective() {
        return objective;
    }
}
