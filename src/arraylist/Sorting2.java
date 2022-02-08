package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting2 {
    public static void main(String[] args) {
        ArrayList<String> takim = new ArrayList<>();
        ArrayList<Integer> puan = new ArrayList<>();

        takim.add("FB");
        puan.add(10);

        takim.add("GS");
        puan.add(5);

        takim.add("BJK");
        puan.add(11);

        takim.add("TS");
        puan.add(8);

        // sort(takim, puan);

        for (int i = 0; i < takim.size(); i++) {
            System.out.println(i + " " + takim.get(i) + " " + puan.get(i));
        }
        System.out.println();

        ArrayList<Integer> order = sorted(takim, puan);

        for (int i = 0; i < order.size(); i++) {
            int orderIndex = order.indexOf(i);

            System.out.println(i + " " + takim.get(orderIndex) + " " + puan.get(orderIndex));
        }
    }

    private static void sort(ArrayList<String> names, ArrayList<Integer> points) {
        for (int i = 0; i < names.size(); i++) {
            for (int j = i + 1; j < names.size(); j++) {
                if (points.get(j) < points.get(i)) {
                    int temp = points.get(i);
                    points.set(i, points.get(j));
                    points.set(j, temp);

                    String name = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, name);
                }
            }
        }
    }

    private static ArrayList<Integer> sorted(ArrayList<String> names, ArrayList<Integer> points) {
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            order.add(i);
        }

        /*

        10, 5, 11, 8 : points
        2, 0, 3, 1 : order
         */

        for (int i = 0; i < names.size(); i++) {
            for (int j = i + 1; j < names.size(); j++) {
                int orderI = order.indexOf(i); // Bulamazsa -1 return eder.
                int orderJ = order.indexOf(j);

                if (points.get(orderJ) > points.get(orderI)) {
                    int temp = order.get(orderI);
                    order.set(orderI, order.get(orderJ));
                    order.set(orderJ, temp);
                }
            }
        }

        return order;
    }

    private static int[] sorted(String[] names, int[] points) {
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            order.add(i);
        }

        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                int orderI = order.indexOf(i);
                int orderJ = order.indexOf(j);

                if (points[orderJ] < points[orderI]) {
                    int temp = order.get(orderI);
                    order.set(orderI, order.get(orderJ));
                    order.set(orderJ, temp);
                }
            }
        }

        int[] orderArray = new int[order.size()];

        for (int i = 0; i < order.size(); i++) {
            orderArray[i] = order.get(i);
        }

        return orderArray;
    }
}
