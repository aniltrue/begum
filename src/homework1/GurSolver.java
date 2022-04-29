package homework1;

import java.util.ArrayList;
import java.util.HashMap;

public class GurSolver {
    // gur/GurobiExp2

    /*
        PAR: C[i]: i. çalışanın kapasitesine
        PAR: M[i][j]: i. çalışan j. işten ne kadar kazanacak (Money)
        PAR: W[i][j]: i. çalışan j. işi kaç saatte yapıyor (Work)
        PAR: V[i][j]: i. çalışan j. işi ne kadar yapıyor (Value)
        PAR: D[j]: j. işin demand

        i: çalışan n
        j: iş      m

        DV: X[i][j]: BINARY i. çalışan j. task'i mi yapıyor

        C1: E(j) X[i][j] * W[i][j] <= C[i] for each i // Çalışma saati kısıtı
        X11 * W11 + X12 * W12 + X13 * W13 * ... <= C1
        X21 * W21 + X22 * W22 + X23 * W23 * ... <= C2
        ...

        C2: E(i) X[i][j] * V[i][j] >= D[j] for each j // Demandlar karşılanmalı
        C3: E(i) X[i][j] <= 5 for each j // Her bir işte maksimum 5 işçi çalışabilir
        OBJ: E(i) E(j) X[i][j] * M[i][j] minimize
     */

    public static HashMap<Worker, HashMap<Task, Boolean>> solve(ArrayList<Worker> workers, ArrayList<Task> tasks) {
        return null;
    }

    public static HashMap<Worker, ArrayList<Task>> solve2(ArrayList<Worker> workers, ArrayList<Task> tasks) {
        return null;
    }
}
