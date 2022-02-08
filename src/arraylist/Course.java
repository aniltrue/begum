package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        // names.remove(5); Hata verir.

        add(names, grades, "Ali", 100);
        add(names, grades, "Ayşe", 90);
        add(names, grades, "Fatma", 95);

        print(names, grades);

        remove(names, grades, "Ayşe");

        print(names, grades);

        add(names, grades, "Hasan", 80);
        add(names, grades, "Fatma", 85);

        print(names, grades);

        // names.remove("Fatma");

        // remove(names, grades, "fATma");

        removeAll(names, grades, "fATma");

        print(names, grades);

        add(names, grades, "Begüm", 75);

        print(names, grades);

        names.add(1, "Anıl");
        grades.add(1, 50.0);

        print(names, grades);

        printReverse(names, grades);
    }

    private static void add(ArrayList<String> names, ArrayList<Double> grades, String name, double grade) {
        names.add(name);
        grades.add(grade);
    }

    private static void print(ArrayList<String> names, ArrayList<Double> grades) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(i + ". öğrenci " + names.get(i) + ": " + grades.get(i));
        }

        System.out.println();
    }

    private static void printReverse(ArrayList<String> names, ArrayList<Double> grades) {
        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(i + ". öğrenci " + names.get(i) + ": " + grades.get(i));
        }

        System.out.println();
    }

    private static boolean remove(ArrayList<String> names, ArrayList<Double> grades, String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).toLowerCase().equals(name.toLowerCase())) {
                String n = names.remove(i);
                double g = grades.remove(i);

                System.out.println(i + ". öğrenci " + n + " (" + g + ") silindi.");

                return true;
            }
        }

        return false;
    }

    private static boolean contains(ArrayList<String> names, String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    private static void removeAll(ArrayList<String> names, ArrayList<Double> grades, String name) {
        // System.out.println(names.remove(0)); 0.'yı siliyor ve o elemanı return ediyor.
        // names.remove("Hakan"); Hakan varsa siliyor ve true return ediyor, yoksa false return.

        // names.contains(name)
        while (contains(names, name)) {
            remove(names, grades, name);
        }
    }
}
