package week8;

import gurobi.*;

import java.util.ArrayList;
import java.util.HashMap;

public class KnapsackClass {
    public static ArrayList<Item> solve(ArrayList<Item> items, int capacity) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        int n = items.size();

        HashMap<String, GRBVar> X = new HashMap<>();

        for (int i = 0; i < n; i++) {
            X.put(items.get(i).getName(), model.addVar(0, 1, 0, GRB.BINARY, "X_" + i));
        }

        // C1
        GRBLinExpr c1_lhs = new GRBLinExpr();

        for (int i = 0; i < n; i++) {
            c1_lhs.addTerm(items.get(i).getWeight(), X.get(items.get(i).getName()));
        }

        model.addConstr(c1_lhs, GRB.LESS_EQUAL, capacity, "C1");

        // Objective
        GRBLinExpr obj = new GRBLinExpr();

        for (int i = 0; i < n; i++) {
            obj.addTerm(items.get(i).getValue(), X.get(items.get(i).getName()));
        }

        model.setObjective(obj, GRB.MAXIMIZE);

        model.optimize();

        ArrayList<Item> x = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (X.get(items.get(i).getName()).get(GRB.DoubleAttr.X) == 1) {
                x.add(items.get(i));
            }
        }

        model.dispose();

        return x;
    }
}
