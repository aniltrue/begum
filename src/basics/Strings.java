package basics;

public class Strings {
    public static void main(String[] args) {
        char c = 'a';
        String str = " Ali";

        str = increase(str);

        System.out.println(str);

        System.out.println(str.charAt(3));

        str = str.toLowerCase();

        System.out.println(str);

        if (str.toUpperCase().trim().equals("ALIVELI"))
            System.out.println("Yazılar Aynı");

        System.out.println(str.length());

        str = "AlİVeli";

        // sadece çift, karışık, sadece tek
        System.out.println(allUpperCase(str.toUpperCase())); // TRUE
        System.out.println(allUpperCase(str)); // FALSE

        System.out.println(anyUpperCase(str)); // TRUE
        System.out.println(anyUpperCase(str.toLowerCase())); // FALSE
    }

    private static String increase(String str) {
        str += "Veli";

        return str;
    }

    // p0 && p1 && p2 && ...
    private static boolean allUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isUpperCase(str.charAt(i))) { // Not UpperCase
                return false;
            }
        }

        return true;
    }

    // p0 || p1 || p2 || ...
    private static boolean anyUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) { // UpperCase
                return true;
            }
        }

        return false;
    }
}
