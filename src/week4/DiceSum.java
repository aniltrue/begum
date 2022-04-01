package week4;

import java.util.Random;
import java.util.Scanner;

public class DiceSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Sayı Giriniz:");
        int desiredSum = console.nextInt();

        while (desiredSum < 2 || desiredSum > 12) {
            System.out.println("Hatalı Girdiniz!");

            System.out.print("Sayı Giriniz:");
            desiredSum = console.nextInt();
        }

        // control
        // içeri
        // control
        // içeri
        // control
        // içeri
        // control

        // içeri
        // control
        // içeri
        // control
        // içeri
        // control

        int sum;

        Random random = new Random();

        do {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;

            sum = dice1 + dice2;

            System.out.println(dice1 + " - " + dice2 + " : " + sum);

        } while (sum != desiredSum);

        System.out.println("You win!");
    }

    public static int rollDice(int n) {
        Random rnd = new Random();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int dice = rnd.nextInt(6) + 1;

            sum += dice;
        }

        return sum;
    }
}
