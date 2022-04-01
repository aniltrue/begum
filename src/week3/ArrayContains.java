package week3;

public class ArrayContains {
    public static boolean contains(int[] arr, int a) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                return true;
            }
        }

        return false;
    }

    public static boolean contains2(int[] arr, int a) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                counter += 1;
            }
        }

        if (counter > 0)
            return true;
        else
            return false;
    }

    // 1, 2, 2, 3, 3, 3
    // 2
    // 4
    public static boolean contains3(int[] arr, int a) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                counter += 1;
            }
        }

        if (counter > 0 && counter % 2 == 0)
            return true;
        else
            return false;
    }
}
