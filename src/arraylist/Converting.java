package arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Converting {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5};

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }

        Collections.sort(al);
        Collections.reverse(al);

        ArrayList<Integer> order = new ArrayList<>();

        order.add(1);
        order.add(3);
        order.add(2);

        int[] orderArray = new int[order.size()];

        for (int i = 0; i < order.size(); i++) {
            orderArray[i] = order.get(i);
        }
    }
}
