package gur;

import gurobi.*;

public class GurobiExp {
    /*
    DV: X, Y, Z
    C1: 2 * X + Y + 3 = 5
    C2: Z + Y - 5 <= X
    C3: Y + 3 * X >= Y + Z

    X: INT [-10, 10]
    Y: CONT [0, SONSUZA)
    Z: CONT (-SONSUZ, 10]

    OBJ: X + Y + Z, MINIMIZE
     */

    private static void solve() throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        GRBVar X = model.addVar(-10, 10, 0, GRB.INTEGER, "X");
        GRBVar Y = model.addVar(0, Double.MAX_VALUE, 0, GRB.CONTINUOUS, "Y");
        GRBVar Z = model.addVar(Double.MIN_VALUE, 10, 0, GRB.CONTINUOUS, "Z");

        GRBLinExpr l1 = new GRBLinExpr();
        l1.addTerm(2, X);
        l1.addTerm(1, Y);
        l1.addConstant(3);

        model.addConstr(l1, GRB.EQUAL, 5, "c1");

        GRBLinExpr l2 = new GRBLinExpr();
        l2.addTerm(1, Z);
        l2.addTerm(1, Y);
        l2.addConstant(-5);

        GRBLinExpr l3 = new GRBLinExpr();
        l3.addTerm(1, X);

        model.addConstr(l2, GRB.LESS_EQUAL, l3, "c2");

        // Y + 3 * X >= Y + Z
        GRBLinExpr l4 = new GRBLinExpr();
        l4.addTerm(1, Y);
        l4.addTerm(3, X);

        GRBLinExpr l5 = new GRBLinExpr();
        l5.addTerm(1, Y);
        l5.addTerm(1, Z);

        model.addConstr(l4, GRB.GREATER_EQUAL, l5, "c3");

        GRBLinExpr obj = new GRBLinExpr();
        obj.addTerm(1, X);
        obj.addTerm(1, Y);
        obj.addTerm(1, Z);

        model.setObjective(obj, GRB.MINIMIZE);
        model.optimize();

        System.out.println(X.get(GRB.DoubleAttr.X));
        System.out.println(Y.get(GRB.DoubleAttr.X));
        System.out.println(Z.get(GRB.DoubleAttr.X));

        model.dispose();
    }
}
