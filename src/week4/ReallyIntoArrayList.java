package week4;

import java.util.ArrayList;

public class ReallyIntoArrayList {
    public static void main(String[] args) {
        ArrayList<Double> arr = new ArrayList<>();

        arr.add(5.);

        double removedElement = arr.remove(6);
        boolean isRemoved = arr.remove(3.0);

        arr.contains(3.0);
        arr.add(2, 4.);
        arr.containsAll(new ArrayList<>());

        arr.clear();
        arr.size();

        arr.indexOf(3.);
        arr.lastIndexOf(2.);

        arr.get(0); // arr[i]
        arr.set(2, 3.); // arr[2] = 3
    }
}
