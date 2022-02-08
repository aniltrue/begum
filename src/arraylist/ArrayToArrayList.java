package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayToArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = new String[10];

        ArrayList<String> students = new ArrayList<>();

        students.add("Ali");
        students.add("Ayşe");
        students.add("Veli");

        ArrayList<Integer> grades = new ArrayList<>();

        grades.add(100);
        grades.add(90);
        grades.add(80);

        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ". öğrenci: " + students.get(i));
        }

        s[1] = "Fatma";
        students.set(1, "Fatma");
        grades.set(1, 70);

        System.out.println();

        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ". öğrenci: " + students.get(i));
        }

        System.out.println();

        students.remove(2);

        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ". öğrenci: " + students.get(i));
        }
    }
}
