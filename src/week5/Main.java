package week5;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Ali", 50);
        Student student2 = new Student("Veli", 60);
        Student student3 = new Student("Hasan", 70);
        Student student4 = new Student("Ayşe", 75);

        System.out.println("Student1: " + student1.getName());
        System.out.println("Student1: " + student1.getGrade());

        student1.setGrade(-10);

        System.out.println("Student1: " + student1.getGrade());

        Course ie246 = new Course("IE 246");

        System.out.println(ie246.getName());
        System.out.println(ie246.name);
        // System.out.println(ie246.students);

        System.out.println(ie246.getStudents());

        ie246.assignStudent(student3);
        ie246.assignStudent(student1);
        ie246.assignStudent(student4);

        System.out.println("Average: " + ie246.getAverage());
        System.out.println("Stdev:" + ie246.getStdev());

        System.out.println(ie246.pdf(student2));

        System.out.println(ie246.contains(student1));
        System.out.println(ie246.contains(student2));

        Student student5 = new Student("Ali", 50);
        student5.setGrade(60);

        student5.equals(student1);
        student5.equals(student5);

        ie246.getStudents().indexOf(student1); // 1
        ie246.getStudents().indexOf(student5); // -1

        ie246.getStudents().contains(student1); // True
        ie246.getStudents().contains(student5); // False

        indexOf(ie246.getStudents(), student5);

        System.out.println(student1.getGrade());

        System.out.println(ie246.contains(student5));
    }

    /*
        Write a method that find index of each arraylist in ther....
        indexOf
        lastIndexOf
        contains
        remove

        //
        equals

        find: name'e baksın
     */

    public static int indexOf(ArrayList<Student> arr, Student s) {
        for (int i = 0; i < arr.size(); i++) {
            if (s.getName().equals(arr.get(i).getName()))
                return i;
        }

        return -1;
    }

    public static boolean equals(Student s1, Student s2) {
        if (s1.getName().equals(s2.getName()))
            return true;

        return false;
    }
}
