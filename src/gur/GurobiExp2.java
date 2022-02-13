package gur;

import gurobi.*;

public class GurobiExp2 {
    /*
        PAR: C[i]: i. çalışanın kapasitesine
        PAR: M[i][j]: i. çalışan j. işten ne kadar kazanacak
        PAR: W[i][j]: i. çalışan j. işi kaç saatte yapıyor
        PAR: V[i][j]: i. çalışan j. işi ne kadar yapıyor
        PAR: D[j]: j. işin demand

        i: çalışan n
        j: iş      m

        DV: X[i][j]: BINARY i. çalışan j. task'i mi yapıyor

        C1: E(j) X[i][j] * W[i][j] <= C[i] for each i
        C2: E(i) X[i][j] * V[i][j] >= D[j] for each j
        C3: E(i) X[i][j] <= 5 for each j // Her bir işte maksimum 5 işçi çalışabilir
        OBJ: E(i) E(j) X[i][j] * M[i][j] minimize
     */

    public static void solve(int[] c, int[][] m, int[][] w, int[][] v, int[] d) throws GRBException {
        GRBEnv env = new GRBEnv();
        GRBModel model = new GRBModel(env);

        int I = c.length; // çalışan sayısı
        int J = d.length; // iş sayısı

        GRBVar[][] X = new GRBVar[I][J];

        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                X[i][j] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i + "_" + j);
            }
        }

        for (int i = 0; i < I; i++) {
            GRBLinExpr l1 = new GRBLinExpr();

            for (int j = 0; j < J; j++) {
                l1.addTerm(w[i][j], X[i][j]);
            }

            model.addConstr(l1, GRB.LESS_EQUAL, c[i], "c1_" + i);
        }

        for (int j = 0; j < J; j++) {
            GRBLinExpr l1 = new GRBLinExpr();

            for (int i = 0; i < I; i++) {
                l1.addTerm(v[i][j], X[i][j]);
            }

            model.addConstr(l1, GRB.GREATER_EQUAL, d[j], "c2_" + j);
        }

        for (int j = 0; j < J; j++) {
            GRBLinExpr l1 = new GRBLinExpr();

            for (int i = 0; i < I; i++) {
                l1.addTerm(1.0, X[i][j]);
            }

            model.addConstr(l1, GRB.LESS_EQUAL, 5, "c3_" + j);
        }

        GRBLinExpr obj = new GRBLinExpr();

        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                obj.addTerm(m[i][j], X[i][j]);
            }
        }

        model.setObjective(obj, GRB.MINIMIZE);
        model.optimize();

        for (int i = 0; i < I; i++) {
            System.out.print(i + ". worker: ");

            double salary = 0.0;
            int hour = 0;
            int production = 0;

            for (int j = 0; j < J; j++) {
                if (X[i][j].get(GRB.DoubleAttr.X) == 1) {
                    System.out.print(j + " ");
                    salary += m[i][j];
                    hour += w[i][j];
                    production += v[i][j];
                }
            }

            System.out.println(" Salary: " + salary + " Hour: " + hour + " Production: " + production);
        }

        System.out.println();
        System.out.println("Objective: " + obj.getValue());

        model.dispose();
    }
}
