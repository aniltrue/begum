package TopDown;

public class KnapsackWithVolume {
    public static void main(String[] args) {
        int[] v = {10, 20, 50, 40, 60};
        int[] w = {3, 5, 7, 6, 8};
        int[] h = {6, 2, 8, 4, 7};
        int W = 20;
        int H = 20;

        V(v.length - 1, W, H, v, w, h);
    }

    private static int V(int i, int j, int k, int[] v, int[] w, int[] h) {
        String print = "V(" + i + ", " + j + ", " + k + ") = ";
        if (i == 0) {
            System.out.println(print + 0);

            return 0;
        } else if (w[i] <= j && h[i] <= k) {
            int take = V(i - 1, j - w[i], k - h[i], v, w, h) + v[i];
            int doNotTake = V(i - 1, j, k, v, w, h);

            print += "max(V(" + (i - 1) + ", " + j + ", " + k + ")";
            print += ", " + v[i] + " + V(" + (i - 1) + ", " + (j - w[i]) + ", " + (k - h[i]) + ")) = ";

            print += "max(" + doNotTake + ", " + take + ") = ";

            int result = Math.max(take, doNotTake);

            print += result;

            System.out.println(print);

            return result;
        } else {
            int doNotTake = V(i - 1, j, k, v, w, h);

            print += "V(" + (i - 1) + ", " + j + ", " + k + ") = ";

            int result = doNotTake;

            print += result;

            System.out.println(print);

            return result;
        }
    }
}

