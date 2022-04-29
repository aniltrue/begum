package week8;

import gurobi.*;

public class KnapsackArray {
    /*
        W_i, V_i, C

        X_i: Bool

        maximize: X_i * V_i
        C1: E X_i * W_i <= C

        X_0 * W0 + X2 * W2 + X3 * W3 + ... + <= C
     */

    public static boolean[] solve(int[] V, int[] W, int C) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        int n = V.length;

        GRBVar[] X = new GRBVar[n];

        for (int i = 0; i < n; i++) {
            X[i] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i);
        }

        // C1
        GRBLinExpr c1_lhs = new GRBLinExpr();

        for (int i = 0; i < n; i++) {
            c1_lhs.addTerm(W[i], X[i]);
        }

        model.addConstr(c1_lhs, GRB.LESS_EQUAL, C, "C1");

        // Objective
        GRBLinExpr obj = new GRBLinExpr();

        for (int i = 0; i < n; i++) {
            obj.addTerm(V[i], X[i]);
        }

        model.setObjective(obj, GRB.MAXIMIZE);

        model.optimize();

        boolean[] x = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (X[i].get(GRB.DoubleAttr.X) == 1) {
                x[i] = true;
            } else {
                x[i] = false;
            }
        }

        model.dispose();

        return x;
    }
}
