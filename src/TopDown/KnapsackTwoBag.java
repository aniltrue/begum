package TopDown;

public class KnapsackTwoBag {
    public static void main(String[] args) {
        int[] v1 = {10, 20, 50, 40, 60};
        int[] v2 = {20, 30, 50, 30, 40};
        int[] w = {3, 5, 7, 6, 8};
        int[] h = {6, 2, 8, 4, 7};
        int W = 15;
        int H = 15;

        V(v1.length - 1, W, H, v1, v2, w, h);
    }

    private static int V(int i, int j, int k, int[] v1, int[] v2, int[] w, int[] h) {
        String print = "V(" + i + ", " + j + ", " + k + ") = ";
        if (i == 0) {
            System.out.println(print + 0);

            return 0;
        } else if (w[i] <= j && h[i] <= k) {
            int take1 = V(i - 1, j - w[i], k, v1, v2, w, h) + v1[i];
            int take2 = V(i - 1, j, k - h[i], v1, v2, w, h) + v2[i];
            int doNotTake = V(i - 1, j, k, v1, v2, w, h);

            print += "max(V(" + (i - 1) + ", " + j + ", " + k + ")";
            print += ", " + v1[i] + " + V(" + (i - 1) + ", " + (j - w[i]) + ", " + k + ")";
            print += ", " + v2[i] + " + V(" + (i - 1) + ", " + j + ", " + (k - h[i]) + ")) = ";

            print += "max(" + doNotTake + ", " + take1 + ", " + take2 + ") = ";

            int result = Math.max(take2, Math.max(take1, doNotTake));

            print += result;

            System.out.println(print);

            return result;
        } else if (w[i] <= j) {
            int take1 = V(i - 1, j - w[i], k, v1, v2, w, h) + v1[i];
            int doNotTake = V(i - 1, j, k, v1, v2, w, h);

            print += "max(V(" + (i - 1) + ", " + j + ", " + k + ")";
            print += ", " + v1[i] + " + V(" + (i - 1) + ", " + (j - w[i]) + ", " + k + ")) = ";

            print += "max(" + doNotTake + ", " + take1 + ") = ";

            int result = Math.max(take1, doNotTake);

            print += result;

            System.out.println(print);

            return result;
        } else if (h[i] <= k) {
            int take2 = V(i - 1, j, k - h[i], v1, v2, w, h) + v2[i];
            int doNotTake = V(i - 1, j, k, v1, v2, w, h);

            print += "max(V(" + (i - 1) + ", " + j + ", " + k + ")";
            print += ", " + v2[i] + " + V(" + (i - 1) + ", " + j + ", " + (k - h[i]) + ")) = ";

            print += "max(" + doNotTake + ", " + take2 + ") = ";

            int result = Math.max(take2, doNotTake);

            print += result;

            System.out.println(print);

            return result;
        } else {
            int doNotTake = V(i - 1, j, k, v1, v2, w, h);

            print += "V(" + (i - 1) + ", " + j + ", " + k + ") = ";

            int result = doNotTake;

            print += result;

            System.out.println(print);

            return result;
        }
    }
}
