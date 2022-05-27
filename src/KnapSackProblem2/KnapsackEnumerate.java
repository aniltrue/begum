package KnapSackProblem2;

import java.util.ArrayList;

public class KnapsackEnumerate {
    /*
        []
    - Items: 3 - i = 0
        []
        [0]
     - Items: 3 - i = 1
        []
        [0]
        [1]
        [0, 1]
      - Items: 3 - i = 2
        []
        [0]
        [1]
        [0, 1]
        [2]
        [0, 2]
        [1, 2]
        [0, 1, 2]
      - i = 3:
        []
        [0]
        [1]
        [0, 1]
        [2]
        [0, 2]
        [1, 2]
        [0, 1, 2]
        [3]
        [0, 3]
        [1, 3]
        [0, 1, 3]
        [2, 3]
        [0, 2, 3]
        [1, 2, 3]
        [0, 1, 2, 3]
     */

    private Problem problem;
    private int objective;

    public KnapsackEnumerate(Problem problem) {
        this.problem = problem;
    }

    public ArrayList<Item> solve() {
        System.out.println("Enumerate");
        ArrayList<ArrayList<Item>> bags = new ArrayList<>();

        bags.add(new ArrayList<>());

        for (int i = 0; i < problem.getItems().size(); i++) {
            ArrayList<ArrayList<Item>> nextBags = new ArrayList<>();

            // i. item'ın 0 olma durumlarını ekledim.
            nextBags.addAll(bags);

            // i. item'ın 1 olma durumuları
            for (int j = 0; j < bags.size(); j++) {
                ArrayList<Item> bag = new ArrayList<>();
                bag.addAll(bags.get(j));

                bag.add(problem.getItems().get(i));

                if (calculateRemainingCapacity(bag) >= 0) {
                    nextBags.add(bag);
                }
            }

            bags = nextBags;
        }

        ArrayList<Item> bestBag = bags.get(0);
        int bestValue = calculateObjective(bestBag);

        for (int i = 1; i < bags.size(); i++) {
            ArrayList<Item> bag = bags.get(i);
            int value = calculateObjective(bag);

            if (value > bestValue) {
                bestBag = bag;
                bestValue = value;
            }
        }

        System.out.println("Objective: " + bestValue);

        return bestBag;
    }

    private int calculateObjective(ArrayList<Item> bag) {
        int value = 0;

        for (int i = 0; i < bag.size(); i++) {
            value += bag.get(i).getValue();
        }

        return value;
    }

    private int calculateRemainingCapacity(ArrayList<Item> bag) {
        int totalWeight = 0;

        for (int i = 0; i < bag.size(); i++) {
            totalWeight += bag.get(i).getWeight();
        }

        return problem.getParameters().capacity - totalWeight;
    }
}
