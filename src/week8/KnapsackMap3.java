package week8;

import gurobi.*;

import java.util.HashMap;

public class KnapsackMap3 {
    public static HashMap<String, Boolean> solve(HashMap<String, Integer> V, HashMap<String, Integer> W, int C) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        HashMap<String, GRBVar> X = new HashMap<>();

        for (String key : V.keySet()) {
            X.put(key, model.addVar(0, 1, 0, GRB.BINARY, "X_" + key));
        }

        // C1
        GRBLinExpr c1_lhs = new GRBLinExpr();

        for (String key : W.keySet()) {
            c1_lhs.addTerm(W.get(key), X.get(key));
        }

        model.addConstr(c1_lhs, GRB.LESS_EQUAL, C, "C1");

        // Objective
        GRBLinExpr obj = new GRBLinExpr();

        for (String key : V.keySet()) {
            obj.addTerm(V.get(key), X.get(key));
        }

        model.setObjective(obj, GRB.MAXIMIZE);

        model.optimize();

        HashMap<String, Boolean> x = new HashMap<>();

        for (String key : V.keySet()) {
            if (X.get(key).get(GRB.DoubleAttr.X) == 1) {
                x.put(key, true);
            } else {
                x.put(key, false);
            }
        }

        model.dispose();

        return x;
    }

}
