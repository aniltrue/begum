package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuestionMain {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, 10, 15.5));
        items.add(new Item(1, 12, 13.5));
        items.add(new Item(2, 13, 12.5));

        items.get(2).setWeight(11.5);

        // value / weight, büyükten küçüğe sırala

        sort(items);

        print(items);

        // [2, 1, 0]
    }

    public static void sort(ArrayList<Item> items) {
        Collections.sort(items, Comparator.comparingDouble(Item::getPoint));
        Collections.sort(items, Comparator.comparingDouble(x -> x.getValue() / x.getWeight()));
        Collections.reverse(items);
    }

    public static void print(ArrayList<Item> items) {
        System.out.print("[");
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).getId());

            if (i < items.size() - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }


    static class Item {
        private int id;
        public int value;
        private double weight;

        public Item(int id, int value, double weight) {
            this.id = id;
            this.value = value;
            this.weight = weight;
        }

        public int getId() {
            return id;
        }

        public int getValue() {
            return value;
        }

        public double getWeight() {
            return weight;
        }

        public double getPoint() {
            return value / weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }
}
