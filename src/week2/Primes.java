package week2;

public class Primes {
    // true && p2 && p3 && p4 && ... && pn
    // false || p2 || p3 || p4 || ... || pn
    public static void main(String[] args) {
        for (int i = 350; i <= 2570; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i);
            }
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
}
