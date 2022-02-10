import java.util.ArrayList;

public class Factorial {
    public static void main(String[] args) {
        factorial(4); // 4!=24

        String[] arr1 = { "Ali", "Veli", "Ayşe", "Ali" };
        String[] arr2 = { "Ali", "Hakan", "veli", "Ayşe" };

        printCommon(arr1, arr2); // Ali Ayşe

        System.out.println(getMiddle("Ali"));
        System.out.println("Ali".charAt(2));
    }


    public static void factorial(int n) {
        // n!=sonuç
        // 1!=1
        // 2!=2
        // 3!=6
        // 4!=24
        // ...
    }


    public static void printCommon(String[] arr1, String[] arr2) {
        ArrayList<String> result = new ArrayList<>(); // Print ettiklerimi aklımda tutuyorum ki aynısı gelirse bir daha yazmayayım.

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j]) && !result.contains(arr1[i])) { // int, double, char, long
                    System.out.println(arr1[i]);
                    result.add(arr1[i]);

                }
            }
        }
    }

    public static char getMiddle(String str) {
        return str.charAt(str.length() / 2);
    }

}
