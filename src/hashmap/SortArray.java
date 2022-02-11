package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SortArray {
    /*
    Provide a method named sortMyArray that can take a vector of doubles as input (should work with both an
    ArrayList<double> and a double[] array) and returns a HashMap where the key is the index of that item in the
    sorted list or array (in ascending order) and value is the item's value.
    For example if I do the following
    double exampleArray={12 , 6 , -1.5, 4.8}
    HashMap<Integer, double> sortedArray = sortMyArray(exampleArray) my sortedArray should
    include <key:0,value:-1.5>, <key:1,value:4.8>, <key:2,value:6>, <key:3,value:12>.
     */

    public static void main(String[] args) {
        double[] exampleArray = {12 , 6 , -1.5, 4.8};
        HashMap<Integer, Double> sortedArray = sortMyArray(exampleArray);

        ArrayList<Double> arr2 = new ArrayList<>();
        arr2.add(12.);
        arr2.add(6.);
        arr2.add(-1.5);
        arr2.add(4.8);

        HashMap<Integer, Double> sortedArray2 = sortMyArray(arr2);

        for (Integer key : sortedArray.keySet()) {
            System.out.println(key + ": " + sortedArray.get(key));
        }
    }

    /*
    public static HashMap<Integer, Double> sortMyArray(ArrayList<Double> arr) {
        // 12, 6, -1.5, 4.8
        // 3, 2, 0, 1
        // 0: -1.5, 1: 4.8, 2: 6, 3: 12 // HashMap

        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            order.add(i);
        } // 0, 1, 2, 3

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int orderI = order.indexOf(i);
                int orderJ = order.indexOf(j);

                if (arr.get(orderJ) < arr.get(orderI)) {
                    int temp = order.get(orderI);
                    order.set(orderI, order.get(orderJ));
                    order.set(orderJ, temp);
                }
            }
        }

        HashMap<Integer, Double> result = new HashMap<>();
        for (int i = 0; i < order.size(); i++) {
            result.put(order.get(i), arr.get(i));
        }

        return result;
    }
    */

    public static HashMap<Integer, Double> sortMyArray(ArrayList<Double> arr) {
        ArrayList<Double> copy = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            copy.add(arr.get(i));
        }

        Collections.sort(copy);

        HashMap<Integer, Double> result = new HashMap<>();

        for (int i = 0; i < copy.size(); i++) {
            result.put(i, copy.get(i));
        }

        return result;
    }

    public static HashMap<Integer, Double> sortMyArray(double[] arr) {
        ArrayList<Double> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }

        return sortMyArray(arrayList);
    }

    public static HashMap<Integer, Double> sortArray(double[] arr) {
        double[] copy = new double[arr.length];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = arr[i];
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[i]) {
                    double temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }

        HashMap<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < copy.length; i++) {
            map.put(i, copy[i]);
        }

        return map;
    }

    public static HashMap<Integer, Double> sortArray(ArrayList<Double> arr) {
        double[] array = new double[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }

        return sortArray(array);
    }
}
