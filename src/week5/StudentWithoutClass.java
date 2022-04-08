package week5;

import java.util.ArrayList;

public class StudentWithoutClass {
    public static void main(String[] args) {
        ArrayList<Integer> grades =  new ArrayList<>();
        grades.add(50);
        grades.add(60);
        grades.add(70);
        grades.add(80);

        double average = mean(grades);
        System.out.println("Mean: " + average);
        double stdev = stdev(grades);
        System.out.println("Standard Derivation: " + stdev);

        int unknownStudentGrade = 65;
        double p = pdf(unknownStudentGrade, average, stdev);
        System.out.println(p);
        if (p > 0.5) {
            System.out.println("Bu öğrenci bu sınıfa aittir.");
        } else {
            System.out.println("Bu öğrenci bu sınıfa ait değildir.");
        }
    }

    public static double mean(ArrayList<Integer> grades) {
        double sum = 0;

        for (Integer grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public static double stdev(ArrayList<Integer> grades) {
        double average = mean(grades);

        double sum = 0.;

        for (Integer grade : grades) {
            sum += Math.pow(grade - average, 2);
        }

        double stdev = Math.sqrt(sum / grades.size());

        return stdev;
    }

    public static double pdf(int grade, double mean, double stdev) {
        return (1. / (stdev * Math.sqrt(2. * Math.PI))) * Math.exp(-0.5 * Math.pow((grade - mean) / stdev, 2.));
    }
}
