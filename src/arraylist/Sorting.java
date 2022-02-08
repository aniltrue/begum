package arraylist;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Integer> points = new ArrayList<>();

        points.add(5);
        points.add(3);
        points.add(1);
        points.add(6);
        points.add(9);

        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i) + " ");
        }

        System.out.println();

        Collections.sort(points);

        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i) + " ");
        }

        System.out.println();

        Collections.reverse(points);

        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i) + " ");
        }

        System.out.println();


    }
}
