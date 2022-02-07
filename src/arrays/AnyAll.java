package arrays;

public class AnyAll {
    public static void main(String[] args) {
        int[] mixed = {1, 2, 3, 4, 5, 6};
        int[] evens = {0, 2, 4, 6, 8};
        int[] odds = {1, 3, 5, 7, 9};

        System.out.println(anyEven2(mixed));
        System.out.println(anyEven2(evens));
        System.out.println(anyEven2(odds));
        System.out.println();
        System.out.println(allEven3(mixed));
        System.out.println(allEven3(evens));
        System.out.println(allEven3(odds));
        System.out.println();
        System.out.println(exactEven(mixed, 3));
        System.out.println(exactEven(mixed, 2));
        System.out.println(exactEven(evens, 3));
        System.out.println(exactEven(evens, 5));
        System.out.println(exactEven(odds, 2));
        System.out.println();

        boolean test = anyEven3(mixed);
        boolean test2 = anyEven4(mixed);

        if (!anyEven4(mixed)) {
            System.out.println("Hepsi tek");
        } else {
            System.out.println("İçinde çift var. (" + countEven(mixed) + ")");
        }
    }

    // p0 || p1 || p2 ...
    private static boolean anyEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                return true;
            }
        }

        return false;
    }

    // p0 && p1 && p2 ...
    private static boolean allEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean anyEven2(int[] arr) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }

        if (counter == 0)
            return false;
        else
            return true;
    }

    private static boolean allEven2(int[] arr) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }

        if (counter == arr.length)
            return true;
        else
            return false;
    }

    private static boolean exactEven(int[] arr, int n) { // arrayde n tane çift var mı
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }

        if (counter == n)
            return true;
        else
            return false;
    }

    private static boolean allEven3(int[] arr) { // Hepsi çift mi
        return exactEven(arr, arr.length); // bu arrayin içinde arr.length kadar çift var mı?
    }

    // 1, 3, 5: exact(arr, 0) = true
    // 2, 3, 5: exact(arr, 0) = false
    private static boolean anyEven3(int[] arr) { // Hiç çift var mı?
        return !exactEven(arr, 0); // bu arrayin içinde 0 tane çift var mı?
    }

    private static int countEven(int[] arr) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }

        return counter;
    }

    private static boolean allEven4(int[] arr) {
        return countEven(arr) == arr.length;
    }

    private static boolean anyEven4(int[] arr) {
        return !(countEven(arr) == 0);
    }
}
