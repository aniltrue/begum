package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Course {
    // private, protected, public, default: Access Modifier
    private ArrayList<Student> students;
    private Teacher teacher;
    private String name;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void print() {
        System.out.println("---------------------------------------------");
        System.out.println("Course:\t" + name + "\tInstructor:\t" + teacher.getName());
        System.out.println();
        printStudents();
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    public void printStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            student.print();

            // students.get(i).print();
        }

        System.out.println();
    }

    public Student findStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name))
                return students.get(i);
        }

        System.out.println("Bulunamadı!");

        return null;
    }

    public void add(Student student) {
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

    public double getAverage() {
        double sum = 0;

        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).getGrade();
        }

        return sum / students.size();
    }

    public void sort() {
        Collections.sort(students, Comparator.comparingInt(Student::getGrade));
        Collections.reverse(students);
    }
}
