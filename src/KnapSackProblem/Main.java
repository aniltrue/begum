package KnapSackProblem;

import gurobi.GRBException;

public class Main {
    public static void main(String[] args) throws GRBException {
        Parameters parameters = new Parameters();
        Problem problem = new Problem(parameters);

        KnapsackGreedy greedy = new KnapsackGreedy(problem);
        greedy.solve1();
        greedy.solve2();
        greedy.solve3();
        greedy.solve4();

        KnapsackRandom random = new KnapsackRandom(problem);
        random.solveMultiple();

        KnapsackRandomSmart smart = new KnapsackRandomSmart(problem);
        smart.solveMultiple();

        KnapsackEnumerate enumerate = new KnapsackEnumerate(problem);
        enumerate.solve();

        KnapsackGurobi gurobi = new KnapsackGurobi(problem);
        gurobi.solve();

        /*
            DP: IE343
            Enumerate: IE246 - IE343
            Solver: IE246
         */
    }
}
