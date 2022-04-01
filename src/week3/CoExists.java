package week3;

import java.util.ArrayList;
import java.util.Arrays;

public class CoExists {
    public static void main(String[] args) {
        String[] arr2 = {"b", "1", "c", "c", "a", "a"};
        String[] arr1 = {"a", "b", "c", "c", "1"};
        // [a, b, c, null]

        System.out.println(Arrays.toString(common(arr1, arr2)));

        System.out.println(getCommons(arr1, arr2));
        System.out.println(Arrays.toString(getCommons2(arr1, arr2)));
    }

    /*
    c(x1, x2) =>
    x1 < x2 : return commons
    x2 < x1 : c(x2, x1)

    c(x1, x2)
    -> c(x2, x1)
    -> commons

    c(x1, x2)
    -> commons
     */

    public static String[] common(String[] arr1, String[] arr2) {
        if (arr2.length < arr1.length) {
            return common(arr2, arr1);
        }

        String[] commons = new String[arr1.length];

        int index = 0;

        for (int i = 0; i < arr1.length; i++) {
            boolean check = true; // Var mı

            for (int j = 0; j < index; j++) {
                if (arr1[i].equals(commons[j])) {
                    check = false;
                    break;
                }
            }

            if (!check) {
                continue;
            }


            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    commons[index] = arr1[i];
                    index += 1;

                    break;
                }
            }
        }

        System.out.println(index);

        String[] result = new String[index];

        for (int i = 0; i < index; i++) {
            result[i] = commons[i];
        }

        return result;
    }

    public static ArrayList<String> getCommons(String[] arr1, String[] arr2) {
        ArrayList<String> commons = new ArrayList<>();

        // a, b, c, b
        // c, b, 1, b
        // b, c

        for (int i = 0; i < arr1.length; i++) {
            if (commons.contains(arr1[i]))
                continue;

            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    commons.add(arr1[i]);

                    break;
                }
            }
        }

        return commons;
    }

    public static String[] getCommons2(String[] arr1, String[] arr2) {
        ArrayList<String> commons = new ArrayList<>();

        // a, b, c, b
        // c, b, 1, b
        // b, c

        for (int i = 0; i < arr1.length; i++) {
            if (commons.contains(arr1[i]))
                continue;

            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    commons.add(arr1[i]);

                    break;
                }
            }
        }

        String[] result = new String[commons.size()];

        for (int i = 0; i < commons.size(); i++) {
            result[i] = commons.get(i);
        }

        return result;
    }
}
