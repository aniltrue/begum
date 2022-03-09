package week2;

public class OddEven {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int value = Integer.parseInt(args[i]);

            System.out.println(value);

            if (value % 2 == 0) {
                System.out.println("Çift");
            } else {
                System.out.println("Tek");
            }

            if (isPrime(value)) {
                System.out.println("Prime");
            } else {
                System.out.println("Prime Değil");
            }

            for (int j = 0; j < value; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i < n / 2; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int power(int a, int b) {
        int power = 1;

        for (int i = 0; i < b; i++) {
            power = power * a;
        }

        return power;
    }
}
