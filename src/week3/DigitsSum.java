package week3;

public class DigitsSum {
    public static void main(String[] args) {
        int a = 123;

        System.out.println(sumDigits(a));
    }

    //a: 0
    //sum: 0 + 3 + 2 + 1
    public static int sumDigits(int a) {
        int sum = 0;

        while (a > 0) {
            int digit = a % 10;

            sum += digit;

            a = a / 10;
        }

        System.out.println(a);

        return sum;
    }

    public static int sumDigits2(int a) {
        System.out.println("" + 1 + 2); // "" + 1 = "1" + 2 = "12"
        System.out.println("" + (1 + 2));
        System.out.println(1 + 2 + "" + 1); // 1 + 2 = 3 + "" = "3" + 1 = "31"
        String s = "" + a; // string + int = string
        // 123 -> "123"
        // "ali" "veli" "ali veli" 8
        // '1'
        // "ali" -> 90 105 106

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // '1' 'a' 'ğ' '?' '''
            // '0': 64
            // '1': 65
            // '2': 66

            int digit = c - '0';

            sum += digit;
        }

        return sum;
    }
}
