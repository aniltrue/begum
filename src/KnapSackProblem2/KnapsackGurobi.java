package KnapSackProblem2;

import gurobi.*;

import java.util.ArrayList;

public class KnapsackGurobi {
    private Problem problem;

    private int objective;

    public KnapsackGurobi(Problem problem) {
        this.problem = problem;
    }

    public ArrayList<Item> solve() throws GRBException {
        System.out.println("Gurobi");
        int n = problem.getParameters().numberOfItems;

        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        /*
        GRBVar[][][] Y = new GRBVar[10][20][30][10]; // Y_ijkl

        // E_k E_l Y_ijkl <= 10 A i, j
        // E_k E_l Y_00kl <= 10
        // E_k E_l Y_01kl <= 10
        // E_k E_l Y_10kl <= 10
        // E_k E_l Y_11kl <= 10

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                GRBLinExpr lhs = new GRBLinExpr();

                for (int k = 0; k < 30; k++) {
                    for (int l = 0; l < 10; l++) {
                        lhs.addTerm(1, Y[i][j][k][l]);
                    }
                }

                model.addConstr(lhs, GRB.LESS_EQUAL, 10, "C1_" + i + "_" + j);
            }
        }
         */

        GRBVar[] X = new GRBVar[n]; // X_i

        for (int i = 0; i < n; i++) {
            X[i] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i);
        }

        GRBLinExpr cl1 = new GRBLinExpr();
        for (int i = 0; i < n; i++) {
            cl1.addTerm(problem.getItems().get(i).getWeight(), X[i]);
        }

        model.addConstr(cl1, GRB.LESS_EQUAL, problem.getParameters().capacity, "c1");

        GRBLinExpr obj = new GRBLinExpr();
        for (int i = 0; i < n; i++) {
            obj.addTerm(problem.getItems().get(i).getValue(), X[i]);
        }

        model.setObjective(obj, GRB.MAXIMIZE);

        model.optimize();

        ArrayList<Item> bag = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (X[i].get(GRB.DoubleAttr.X) == 1) {
                bag.add(problem.getItems().get(i));
            }
        }

        System.out.println("Objective: " + obj.getValue());
        this.objective = (int) obj.getValue();

        return bag;
    }
}
