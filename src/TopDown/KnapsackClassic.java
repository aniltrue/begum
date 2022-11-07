package TopDown;

public class KnapsackClassic {
    public static void main(String[] args) {
        int[] v = {10, 20, 50, 40, 60};
        int[] w = {3, 5, 7, 6, 8};
        int W = 20;

        V(v.length - 1, W, v, w);
    }

    private static int V(int i, int j, int[] v, int[] w) {
        String print = "V(" + i + ", " + j + ") = ";
        if (i == 0) {
            System.out.println(print + 0);

            return 0;
        } else if (w[i] <= j) {
            int take = V(i - 1, j - w[i], v, w) + v[i];
            int doNotTake = V(i - 1, j, v, w);

            print += "max(V(" + (i - 1) + ", " + j + ")";
            print += ", " + v[i] + " + V(" + (i - 1) + ", " + (j - w[i] + ")) = ");

            print += "max(" + doNotTake + ", " + take + ") = ";

            int result = Math.max(take, doNotTake);

            print += result;

            System.out.println(print);

            return result;
        } else {
            int doNotTake = V(i - 1, j, v, w);

            print += "V(" + (i - 1) + ", " + j + ") = ";

            int result = doNotTake;

            print += result;

            System.out.println(print);

            return result;
        }
    }
}
