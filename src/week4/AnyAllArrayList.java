package week4;

import java.util.ArrayList;

public class AnyAllArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(4);
        arr.add(3);
        arr.add(5);
        arr.add(5);

        System.out.println(allUnique(arr));
        System.out.println(anyUnique(arr));
    }

    public static boolean allUnique(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            boolean check = true;

            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(i) == arr.get(j) && i != j) {
                    check = false;
                    break;
                }
            }

            if (!check) {
                return false;
            }
        }

        return true;
    }

    public static boolean anyUnique(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            boolean check = true; // Unique kabul et

            // Aynısından var mı
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(i) == arr.get(j) && i != j) {
                    check = false;
                    break;
                }
            }

            if (check) { // Unique mi
                return true;
            }
        }

        return false;
    }

    public static boolean anyUnique2(ArrayList<Integer> arr) {
        // 4, 4, 3, 5, 5
        for (int i = 0; i < arr.size(); i++) {
            int element = arr.remove(i);

            if (!arr.contains(element)) {
                arr.add(i, element);

                return true;
            }

            arr.add(i, element);
        }

        return false;
    }

    public static boolean allUnique2(ArrayList<Integer> arr) {
        // 4, 4, 3, 5
        for (int i = 0; i < arr.size(); i++) {
            int element = arr.remove(i);

            if (arr.contains(element)) {
                arr.add(i, element);

                return false;
            }

            arr.add(i, element);
        }

        return true;
    }

    public static boolean anyUnique3(ArrayList<Integer> arr) {
        ArrayList<Integer> arr2 = new ArrayList<>(arr);
        // 3, 5, 5
        for (int x : arr) {
            int element = arr2.remove(0);

            if (!arr2.contains(element)) {
                return true;
            }

            arr2.add(element);
        }

        return false;
    }
}
