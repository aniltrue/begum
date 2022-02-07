package basics;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        // doWhile();

        whileLoopSum(25);
        int m = 45;
        whileLoopSum(m);

        Scanner scanner = new Scanner(System.in);

        int n = readInt(scanner, "Enter number of student: ");

        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            grades[i] = readInt(scanner, (i + 1) + "th student's grade: ");
        }

        double mean = calculateAverage(grades);
        double stdv = calculateStdv(grades);

        System.out.println("Average: " + mean + ", Stdev: " + stdv);
        System.out.printf("Average: %.2f, Stdev: %.2f\n", mean, stdv);
    }

    private static void forLoop() {
        int i = 3;

        System.out.println(i);

        for (i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println(i);
    }

    private static void forLoopSum(int n) {
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

    private static void whileLoop() {
        int i = 0;
        while (i < 10) {
            System.out.print(i + " ");

            i++;
        }

        System.out.println();
    }

    private static void whileLoopSum(int n) {
        int sum = 0;

        int i = 0;
        while (i <= n) {
            sum += i;
            i++;
        }

        System.out.println(sum);
    }

    private static void whileLoop2() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.nextInt() >= 0) {
            System.out.println("Hello World.");
        }
    }

    private static void forLoop2() {
        Scanner scanner = new Scanner(System.in);

        for (; scanner.nextInt() >= 0; ) {
            System.out.println("Hello World.");
        }
    }

    private static void scannerLoop() {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        while (number < 0) {
            System.out.println("Wage cannot be a negative number! (" + number + ")");

            number = scanner.nextInt();
        }

        System.out.println("Your wage: " + number);
    }

    private static void scannerLoop2() {
        Scanner scanner = new Scanner(System.in);

        int number;
        int counter;

        for (number = scanner.nextInt(), counter = 1; number < 0 && counter <= 5; number = scanner.nextInt(), counter++) {
            System.out.println("Wage cannot be a negative number! (" + number + "), try (" + counter + "): ");
        }

        System.out.println("Your wage: " + number);
    }

    private static void doWhile() {
        Scanner scanner = new Scanner(System.in);

        int number;

        do {
            number = scanner.nextInt();
        } while(number < 0);

        System.out.println("Your wage is: " + number);
    }

    private static int readInt(Scanner scanner, String text) {
        System.out.print(text);

        int number;

        for (number = scanner.nextInt(); number <= 0; number = scanner.nextInt()) {
            System.out.print("Try again: ");
        }

        return number;
    }

    private static double calculateAverage(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum / (double) arr.length;
    }

    private static double calculateStdv(int[] arr) {
        int sum = 0;

        for (int element : arr) {
            sum += element;
        }

        double avg = sum / (double) arr.length;

        double total = 0.;

        for (int e : arr) {
            total = Math.pow(e - avg, 2);
        }

        return Math.sqrt(total / arr.length);
    }

    private static double calculateStdv2(int[] arr) {
        double average = calculateAverage(arr);

        double total = 0.;

        for (int e : arr) {
            total = Math.pow(e - average, 2);
        }

        return Math.sqrt(total / arr.length);
    }

    private static int sum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }

        return sum;
    }
}
