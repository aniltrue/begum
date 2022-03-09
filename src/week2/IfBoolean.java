package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class IfBoolean {
    public static void main(String[] args) {
        int a = 12;

        if (a % 2 == 0) { // Çiftse
            System.out.println("1");
        } else if (a < 0) { // Çift değilse ve 0'dan küçükse
            System.out.println("2");
        } else if (a < 10) { // Çift değilse ve 0'dan küçük değilse ve 10'dan küçükse
            System.out.println("3");
        } else { // Çift değilse ve 0'dan küçük değilse ve 10'dan küçükse
            System.out.println("4");
        }

        boolean result = a % 2 == 0;

        if (result)
            System.out.println("1");
        if (!result && a < 0)
            System.out.println("2");
        if (a % 2 != 0 && a >= 0 && a < 10)
            System.out.println("3");
        if (a % 2 != 0 && a >= 0 && a >= 10)
            System.out.println("4");

        String str = "";

        // c1 && c2
        if (str.length() > 0 && str.charAt(0) == 'a') {
            System.out.println("Hello");
        }

        Collections.sort(new ArrayList<Integer>(), Comparator.comparingInt(i -> i));
        (new ArrayList<Integer>()).removeIf(IfBoolean::control);
        (new ArrayList<Integer>()).removeIf(i -> i % 2 == 0);



        if (str.length() > 0) {
            if (str.charAt(0) == 'a') {
                System.out.println("Hello");
            }
        }

        boolean c1 = true; // Hızlı çalışıyor
        boolean c2 = true; // Yavaş çalışıyor

        String password = "abc123*";
        String login = "123abc*";

        if (password.length() != login.length() || !password.equals(login)) {
            System.out.println("Tekrar Deneyiniz!");
        }

    }

    public static boolean control(int i) {
        return i % 2 == 0;
    }

    public static ArrayList<Integer> removeIf(ArrayList<Integer> arr, Predicate<Integer> method) {
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (Integer i : arr) {
            if (!method.test(i)) {
                arr2.add(i);
            }
        }

        return arr2;
    }
}
