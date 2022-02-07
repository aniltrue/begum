package arrays;

public class AllUnique {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 3, 5};

        System.out.println(allUnique(arr1)); // True
        System.out.println(allUnique(arr2)); // False
    }

    // All elements are unique
    private static boolean allUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (check(arr, i)) { // array'in i'nci elemanından başka var mı
                return false;
            }
        }

        return true;
    }

    // Any 1, 2, 3, 3
    private static boolean check(int[] arr, int i) { // array'in i'nci elemanından başka var mı
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == arr[i] && i != j) {
                return true;
            }
        }

        return false;
    }

    // 1, 2, 3, 3, 4, 5,
    // 1-2
    // 2-1
    private static boolean allUnique2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean check = false; // Önce yok kabul et.

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i] && i != j) {
                    check = true; // Varmış
                    break;
                }
            }

            if (check) {
                return false;
            }
        }

        return true;
    }

    private static boolean allUnique3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isPrime(int n) {
        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i < n / 2; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
