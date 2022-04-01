package week4;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Double> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arr.add(Math.exp(i));
        }

        System.out.println(arr);

        arr.set(3, Math.PI); // arr[3] = PI
        arr.set(4, Math.PI); // arr[4] = PI
        arr.add(Math.PI); // arr[4] = PI
        arr.add(5.6);

        System.out.println(arr);

        // If PI exists in arr, insert E into last index of PI. Otherwise, add E at the end of arr.
        if (arr.contains(Math.PI)) {
            arr.add(arr.lastIndexOf(Math.PI), Math.E);
        } else {
            arr.add(Math.E);
        }

        System.out.println(arr);

        double removedElement = arr.remove(2); // Garanti ediyorum. Yoksa hata
        System.out.println(removedElement);
        // removedElement = arr.remove(25); Hata Verir!
        boolean isRemoved = arr.remove(Math.PI); // Yoksa false return eder, varsa silip true return eder
        System.out.println(isRemoved);

        System.out.println(arr);

        isRemoved = remove(arr, Math.PI);

        System.out.println(isRemoved);
        System.out.println(arr);

        System.out.println(remove(arr, 132312.43));
    }

    public static boolean remove(ArrayList<Double> arr, double element) {
        int index = arr.lastIndexOf(element);

        if (index == -1) {
            return false;
        }

        // arr:  [3, 1, 0, 2, 4]
        // arr2: []
        ArrayList<Double> arr2 = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            arr2.add(arr.get(i));
        }

        for (int i = index + 1; i < arr.size(); i++) {
            arr2.add(arr.get(i));
        }

        arr.clear();
        arr.addAll(arr2);

        return true;
    }

    public static int indexOf(ArrayList<Double> arr, double element) {
        // 2 veya daha fazla varsa baştan 2.'nin indexini ver.
        // sadece 1 tane varsa 1.'nin indexini ver
        // hiç yoksa -1

        // 2, 2, 3, 2, 4, 3

        int counter = 0;

        int i = 0;
        int lastSeen = -1;

        for (double x : arr) {
            if (x == element) {
                counter++;
                lastSeen = i;
            }

            if (counter == 2) {
                return i;
            }

            i++;
        }

        return lastSeen;
    }

    public static int indexOf(ArrayList<Double> arr, double element, int n) {
        // n veya daha fazla varsa baştan n.'nin indexini ver.
        // n'den daha az varsa tane varsa ilk görüdüğünü indexini ver
        // hiç yoksa -1

        // 2, 2, 3, 2, 4, 3, 2, 3

        int counter = 0;

        int i = 0;
        int firstSeen = -1;

        for (double x : arr) {
            if (x == element) {
                counter++;
                if (firstSeen == -1) {
                    firstSeen = i;
                }
            }

            if (counter == n) {
                return i;
            }

            i++;
        }

        return firstSeen;
    }

    public static int indexOf2(ArrayList<Double> arr, double element, int n) {
        ArrayList<Integer> indices = new ArrayList<>();

        // element: 5
        // n:       4
        // 3, 5, 7, 8, 9, 12, 15, 23

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == element) {
                indices.add(i);
            }
        }

        if (indices.size() >= n) {
            return indices.get(n - 1);
        } else
            return -1;

    }
}
