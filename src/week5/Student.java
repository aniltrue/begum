package week5;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
            // return true;
        } else {
            System.out.println("Hatalı grade girdiniz.");
        }

        // return this.grade;
    }

    /*
        Constructor
        equals()
        toString()
        hashCode()
     */

    public boolean equals(Object o) {
        Student student = (Student) o;

        return name.equals(student.name);
    }

    public static boolean equals(Student s1, Student s2) {
        if (s1.getName().equals(s2.getName()))
            return true;

        return false;
    }
}
