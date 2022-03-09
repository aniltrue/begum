package week2;

import java.util.Arrays;
import java.util.Random;

public class randInc {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2};
        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.println(arr[i]);
            else
                System.out.println(randInt(arr[i], arr[i + 1]));
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            int number1 = arr[i];
            int number2;

            if (i == arr.length - 1)
                number2 = arr[i];
            else
                number2 = arr[i + 1];

            // int number2 = i == arr.length - 1 ? arr[i] : arr[i + 1];

            arr2[i] = randInt(number1, number2);

            System.out.println(arr2[i]);
        }

        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < arr.length - 1; i++)
            System.out.println(randInt(arr[i], arr[i + 1]));

        System.out.println(arr[arr.length - 1]);
    }

    public static int randInt(int s1, int s2) {
        Random rnd = new Random();

        // return rnd.nextInt(Math.max(s1, s2) + 1 - Math.min(s1, s2)) + Math.min(s1, s2);

        // return s2 > s1 ? rnd.nextInt(s2 + 1 - s1) + s1 : rnd.nextInt(s1 + 1 - s2) + s2;

        if (s2 > s1)
            return rnd.nextInt(s2 + 1 - s1) + s1;
        else
            return rnd.nextInt(s1 + 1 - s2) + s2;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
