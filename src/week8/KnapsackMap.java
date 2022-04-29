package week8;

import gurobi.*;

import java.util.HashMap;

public class KnapsackMap {
    public static HashMap<Integer, Boolean> solve(HashMap<Integer, Integer> V, HashMap<Integer, Integer> W, int C) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        int n = V.size();

        GRBVar[] X = new GRBVar[n];

        for (int i = 0; i < n; i++) {
            X[i] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i);
        }

        // C1
        GRBLinExpr c1_lhs = new GRBLinExpr();

        for (int i = 0; i < n; i++) {
            c1_lhs.addTerm(W.get(i), X[i]);
        }

        model.addConstr(c1_lhs, GRB.LESS_EQUAL, C, "C1");

        // Objective
        GRBLinExpr obj = new GRBLinExpr();

        for (int i = 0; i < n; i++) {
            obj.addTerm(V.get(i), X[i]);
        }

        model.setObjective(obj, GRB.MAXIMIZE);

        model.optimize();

        HashMap<Integer, Boolean> x = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (X[i].get(GRB.DoubleAttr.X) == 1) {
                x.put(i, true);
            } else {
                x.put(i, false);
            }
        }

        model.dispose();

        return x;
    }
}
