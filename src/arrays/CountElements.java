package arrays;

import java.util.Arrays;

public class CountElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 3, 4, 7};
        // [2, 2, 1, 3, 3, 3, 1]
        // 0, 1, 2, 3, 4, 5, 6, 7
        // 0, 2, 1, 3, 1, 0, 0, 1

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(count(arr)));

        System.out.println();

        System.out.println(Arrays.toString(count2(arr)));
    }

    private static int[] count(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    private static int[] count2(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int[] result = new int[max + 1];

        // 1, 2, 2, 3, 5, 0
        // 1, 1, 2, 1, 0, 1
        for (int i = 0; i < arr.length; i++) {
            result[arr[i]]++;
        }

        return result;
    }
}
