package arrays;

public class AnyUnique {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 3, 3};
        int[] arr2 = {1, 1, 2, 2, 3, 4, 4, 4};

        System.out.println(anyUnique(arr1)); // False
        System.out.println(anyUnique(arr2)); // True
    }

    // Her sayıdan birden fazla olması gerekiyor / Hiç unique var mı
    private static boolean anyUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean check = true; // Unique kabul et

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) { // AAA unique değilmiş
                    check = false; // Başka aynı sayıdan var.
                    break;
                }
            }

            if (check) {
                return true;
            }
        }

        return false;
    }
}
