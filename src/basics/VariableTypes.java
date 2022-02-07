package basics;

public class VariableTypes {
    public static void main(String[] args) {
        int x = 5;      // 100
        char c = 'a';   // 101
        double d = 5.0; // 102

        x = x + 5; // 100: 10

        System.out.println(x);

        x = increase(x);

        System.out.println(x);

        // Objeler
        // Array

        int[] arr = new int[5]; // 0, 1, 2, 3, 4 // 105
        arr[2] = 3; // 105.2 = 3

        printArray(arr);

        increase(arr);

        printArray(arr);

        arr = increaseSize(arr);

        printArray(arr);

        int[] arr2 = increaseInside(arr);

        printArray(arr);
        printArray(arr2);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + ", ");
        }

        System.out.println("]");
    }

    private static int increase(int a) {
        // 103: 10
        a += 1; // a = a + 1

        return a;
    }

    private static void increase(int[] ar) {
        int sum = 0;

        for (int i = 0; i < ar.length; i++) {
            ar[i] += 1;
            sum += ar[i];
        }
    }

    private static int[] increaseSize(int[] arr) {
        int[] newArr = new int[arr.length + 1]; // 106

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr; // arr: 105 değil 106

        return newArr;
    }

    private static int[] increaseInside(int[] arr) {
        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i] + 1;
        }

        return copy;
    }

    // private static void sort(int[] arr);

    // private static int[] sort(int[] arr);
}
