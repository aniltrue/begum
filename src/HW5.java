import gurobi.*;

import java.util.Arrays;

public class HW5 {
	static String[] workerNames = {"Amy", "Bob", "Cathy", "Dan", "Ed", "Fred", "Gu"};
	static String[] shiftNames = {};
	static double[][] w = {};
	String name;

	public static void main(String args[]) throws GRBException {
		int[] demand = {3, 2, 4, 4, 5, 6, 5, 2, 2, 3, 4, 6, 7, 5};
		int[] payment = {10, 12, 10, 8, 8, 9, 11};
		int[][] availability = {{0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
				{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

		System.out.println(w.length);
		if (w.length > 0)
			System.out.println(w[0].length);
		else
			System.out.println(0);
		// solve(payment, demand, availability);
	}

	/*
		X_ij

		- sum_i X_ij = 1 for all j
		- sum_j X_ij * w_ij <= c_i for all i
		double[][] w;
		w[0] -> double[];
		double[] c;

		ArrayList<ArrayList<Double>> w;

		w.size()

		w.get(0).size
		w.get(1).size

		ArrayList<ArrayList<GRBVar>> X;

		for (int i = 0; i < w.size(); i++) {
			X.add(new ArrayList());

			for (int j = 0; j < w.get(i).size(); j++) {
				X.get(i).add(model.addVar(...));
			}
		}

		w.length veya c.length -> i sayısını
		w[0].length -> j sayısını
		w[0][0].length -> k sayısını

		n = w.length;
		if (n == 0) {
			System.out.println("Error! w is empty!");
			return;
		}
		m = 0;

		if (n > 0)
			m = w[0].length;

		- sum_i X_ij >= d_j for all j
		- X_ij <= a_ij for all i and j

		s.t.
		- sum_i a_ij * X_ij >= d_j for all j
		- 1 1
		- 1 1
		- 0 0
		- 1 0
		- 1 1

		Objective:
		- minimize: sum_i sum_j X_ij * p_i
	 */

	public static void solve(int[] payment, int[] demand, int[][] availability) throws GRBException {
		GRBEnv env = new GRBEnv();
		GRBModel model = new GRBModel(env);

		int n = payment.length;
		int m = demand.length;
		GRBVar[][] X = new GRBVar[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				X[i][j] = model.addVar(0, 1, 0, GRB.BINARY, "X_" + i + "_" + j);
			}
		}
		for (int j = 0; j < m; j++) {
			GRBLinExpr l1 = new GRBLinExpr();
			for (int i = 0; i < n; i++) {
				l1.addTerm(1, X[i][j]);
			}
			model.addConstr(l1, GRB.GREATER_EQUAL, demand[j], "c1" + j);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				GRBLinExpr l = new GRBLinExpr();

				l.addTerm(1, X[i][j]);

				model.addConstr(l, GRB.LESS_EQUAL, availability[i][j], "c2_" + i + "_" + j);
			}
		}

		GRBLinExpr obj = new GRBLinExpr();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				obj.addTerm(payment[i], X[i][j]);
			}
		}
		model.setObjective(obj, GRB.MINIMIZE);
		model.optimize();

		for (int j = 0; j < m; j++) {
			System.out.println("Shift " + j + ": ");

			for (int i = 0; i < n; i++) {
				if (X[i][j].get(GRB.DoubleAttr.X) == 1) {
					System.out.println(" - " + workerNames[i]);
				}
			}
		}
		model.dispose();
	}
}
