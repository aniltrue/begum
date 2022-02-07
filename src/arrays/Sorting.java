package arrays;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 3, 1, 4, 8};
        // 1, 2, 3, 3, 4, 6, 8
        System.out.println(Arrays.toString(arr));
        System.out.println();

        int[] order = sorted(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(order));

        System.out.println();

        int[] sortedArray = sorted2(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortedArray));
        System.out.println();

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    // 1, 2, 3, 4
    public static void sort(int[] arr) { // Direkt kendisini sırala
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    // 3, 2, 1
                    int temp = arr[i]; // 1
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] sorted(int[] arr) { // Sıralanmış halinin indexlerini göster
        int[] order = new int[arr.length];

        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }

        // i: 1, j: 3
        // 3, 1, 4, 2: arr
        // 1, 0, 2, 3: order
        // 2, 0, 3, 1

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int orderI = 0;
                int orderJ = 0;

                for (int k = 0; k < order.length; k++) {
                    if (order[k] == i) {
                        orderI = k;
                    }
                    if (order[k] == j) {
                        orderJ = k;
                    }
                }

                if (arr[orderJ] < arr[orderI]) {
                    int temp = order[orderI];
                    order[orderI] = order[orderJ];
                    order[orderJ] = temp;
                }
            }
        }

        return order;
    }

    public static int[] sorted2(int[] arr) { // Copy oluştur ve onu sırala
        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[i]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }

        return copy;
    }
}
