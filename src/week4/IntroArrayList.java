package week4;

import java.util.Arrays;

public class IntroArrayList {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 3, 3, 3};

        System.out.println(Arrays.toString(arr));

        arr = add(arr, 5);

        System.out.println(Arrays.toString(arr));

        arr = remove(arr, 2);

        System.out.println(Arrays.toString(arr));

        System.out.println(indexOf(arr, 3));
        System.out.println(indexOf(arr, 4));
        System.out.println(lastIndexOf(arr, 3));

        System.out.println(indexOf(arr, 3, 2));

        arr = insert(arr, 4, 2);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] add(int[] arr, int element) {
        int[] result = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        result[result.length - 1] = element;

        return result;
    }

    public static int[] remove(int[] arr, int index) { // 2
        int[] result = new int[arr.length - 1];

        // [a, b, c, d, e] -> [a, b, d, e]

        // [0, 1, 2, 3, 4] - [0, 1, 3, 4]

        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }

        for (int i = index + 1; i < arr.length; i++) {
            result[i - 1] = arr[i];
        }

        return result;
    }

    public static int indexOf(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }

        return -1; // Not Found
    }

    public static int indexOf(int[] arr, int element, int n) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                counter++;
            }

            if (counter == n) {
                return i;
            }
        }

        return -1;
    }

    public static int lastIndexOf(int[] arr, int element) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == element) {
                return i;
            }
        }

        return -1; // Not Found
    }

    public static int[] insert(int[] arr, int element, int index) {
        int[] result = new int[arr.length + 1];

        // [3, 0 ,2]; 5, 1 -> [3, 5, 0, 2]
        // [3, 5, 0, 2]

        for (int i = 0; i < index; i++) { // [0, index)
            result[i] = arr[i];
        }

        result[index] = element;

        for (int i = index; i < arr.length; i++) { // [index, n)
            result[i + 1] = arr[i];
        }

        return result;
    }

    public static boolean contains(int[] arr, int element) {
        // return indexOf(arr, element) != -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return true;
            }
        }

        return false;
    }

    public static boolean contains2(int[] arr, int element) {
        boolean check = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                check = true;
                break;
            }
        }

        return check;
    }

    public static boolean containsAll(int[] arr, int[] elements) {
        // [3, 0 ,2 ,4 ,6] -> [3, 4] : true
        // [3, 0 ,2 ,4 ,6] -> [3, 5] : false
        // [3, 0 ,2 ,4 ,6] -> [7, 5] : false

        for (int i = 0; i < elements.length; i++) {
            boolean check = false; // Yok kabul ediyoruz

            // Var mı diye bak
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == elements[i]) {
                    check = true;
                    break;
                }
            }

            if (!check) { // Yok mu
                return false;
            }
        }

        return true;
    }

    public static boolean containsAny(int[] arr, int[] elements) {
        // [3, 0 ,2 ,4 ,6] -> [3, 4] : true
        // [3, 0 ,2 ,4 ,6] -> [3, 5] : true
        // [3, 0 ,2 ,4 ,6] -> [7, 5] : false

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == elements[i]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean containsAny2(int[] arr, int[] elements) {
        boolean check2 = false;

        for (int i = 0; i < elements.length; i++) {
            // [3, 0 ,2] : [5, 3] == [3, 5]
            boolean check = contains(arr, elements[i]);

            if (check) {
                check2 = true;
                break;
            }
        }

        return check2;
    }

    public static boolean containsAll2(int[] arr, int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            boolean check = contains(arr, elements[i]);

            if (!check) {
                return false;
            }
        }

        return true;
    }

    public static boolean notContainsAny(int[] arr, int[] elements) { //  Olmayan var mı
        // [3, 0 ,2 ,4 ,6] -> [3, 4] : false
        // [3, 0 ,2 ,4 ,6] -> [3, 5] : true
        // [3, 0 ,2 ,4 ,6] -> [7, 5] : true

        return !containsAll(arr, elements);
    }

    // containsAll == notContainsAny
    // containsAny == notContainsAll

    // allPrime == notPrimeAny
}
