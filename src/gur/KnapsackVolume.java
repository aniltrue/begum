package gur;

import gurobi.*;

public class KnapsackVolume {
    /*
        PAR: CapacityVolume
        PAR: CapacityWeight
        PAR: weights[]
        PAR: values[]
        PAR: volumes[]

        DV: X[i]: Binary
        C1: E w[i] * X[i] <= CapacityWeight
        C2: E vol[i] * X[i] <= CapacityVolume

        OBJ: Maximize E v[i] * X[i]
     */

    public static double solve(int[] weights, int[] values, int[] volumes, int capacityWeight, int capacityVolume) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        int n = weights.length;

        GRBVar[] X = new GRBVar[n];

        for (int i = 0; i < n; i++) {
            X[i] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i);
        }

        GRBLinExpr l1 = new GRBLinExpr();
        for (int i = 0; i < n; i++) {
            l1.addTerm(weights[i], X[i]);
        }

        model.addConstr(l1, GRB.LESS_EQUAL, capacityWeight, "contraint1");

        GRBLinExpr l2 = new GRBLinExpr();
        for (int i = 0; i < n; i++) {
            l2.addTerm(volumes[i], X[i]);
        }

        model.addConstr(l2, GRB.LESS_EQUAL, capacityVolume, "constraint2");

        GRBLinExpr obj = new GRBLinExpr();
        for (int i = 0; i < n; i++) {
            obj.addTerm(values[i], X[i]);
        }

        model.setObjective(obj, GRB.MAXIMIZE);
        model.optimize();

        return obj.getValue();
    }
}
