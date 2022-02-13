package gur;

import gurobi.*;

public class Knapsack {
    public static void main(String[] args) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);



        model.dispose();
    }

    public static boolean[] solve(int[] weights, int[] values, int capacity) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        GRBVar[] X = new GRBVar[weights.length];

        for (int i = 0; i < weights.length; i++) {
            X[i] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i);
        }

        // E X[i] * w[i] <= c
        // X_1 * w_1 + X_2 * w_2 + ...
        // X_1 + X_2 + X_3 + ...

        GRBLinExpr constraint1 = new GRBLinExpr();
        for (int i = 0; i < weights.length; i++) {
            constraint1.addTerm(weights[i], X[i]);
        }

        model.addConstr(constraint1, GRB.LESS_EQUAL, capacity, "weight_const");

        // E X[i] * v[i]
        GRBLinExpr obj = new GRBLinExpr();
        for (int i = 0; i < weights.length; i++) {
            obj.addTerm(values[i], X[i]);
        }

        model.setObjective(obj, GRB.MAXIMIZE);
        model.optimize();

        System.out.println("Total values: " + obj.getValue());
        System.out.println("Total weight: " + constraint1.getValue());

        boolean[] result = new boolean[X.length];

        for (int i = 0; i < X.length; i++) {
            System.out.println(X[i].get(GRB.DoubleAttr.X));

            if (X[i].get(GRB.DoubleAttr.X) == 1.0) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        model.dispose();

        return result;
    }
}
