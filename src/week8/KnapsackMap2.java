package week8;

import gurobi.*;

import java.util.HashMap;

public class KnapsackMap2 {
    public static HashMap<String, Boolean> solve(HashMap<String, Integer> V, HashMap<String, Integer> W, int C) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        int n = V.size();

        GRBVar[] X = new GRBVar[n];

        for (int i = 0; i < n; i++) {
            X[i] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i);
        }

        // C1
        GRBLinExpr c1_lhs = new GRBLinExpr();

        int i = 0;
        for (String key : W.keySet()) {
            c1_lhs.addTerm(W.get(key), X[i]);
            i++;
        }

        model.addConstr(c1_lhs, GRB.LESS_EQUAL, C, "C1");

        // Objective
        GRBLinExpr obj = new GRBLinExpr();

        i = 0;
        for (String key : V.keySet()) {
            obj.addTerm(V.get(key), X[i]);
            i++;
        }

        model.setObjective(obj, GRB.MAXIMIZE);

        model.optimize();

        HashMap<String, Boolean> x = new HashMap<>();

        i = 0;
        for (String key : V.keySet()) {
            if (X[i].get(GRB.DoubleAttr.X) == 1) {
                x.put(key, true);
            } else {
                x.put(key, false);
            }

            i++;
        }

        model.dispose();

        return x;
    }
}
