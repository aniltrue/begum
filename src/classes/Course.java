package classes;

import java.util.ArrayList;

public class Course {
    public ArrayList<Student> students;
    public Teacher teacher;
    public String name;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        students = new ArrayList<>();
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
            if (students.get(i).name.equals(name))
                return students.get(i);
        }

        System.out.println("Bulunamadı!");

        return null;
    }

    public void add(Student student) {
        students.add(student);
    }

    public double getAverage() {
        double sum = 0;

        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).grade;
        }

        return sum / students.size();
    }
}
