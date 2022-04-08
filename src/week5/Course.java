package week5;

import java.util.ArrayList;

public class Course {
    public String name;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void assignStudent(Student student) {
        System.out.println(student.getName() + " is assigned to " + name);
        students.add(student);
    }

    public double getAverage(ArrayList<Student> arr) {
        double sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            Student student = arr.get(i);

            System.out.println(student.getName());
            sum += student.getGrade();
        }

        sum = 0;

        for (Student element : arr) {
            sum += element.getGrade();
        }

        return sum / arr.size();
    }

    public double getAverage() {
        double sum = 0;

        for (Student student : students) {
            sum += student.getGrade();
        }

        return sum / students.size();
    }

    public double getStdev() {
        double average = getAverage();

        double sum = 0;

        for (Student student : students) {
            sum += Math.pow(student.getGrade() - average, 2.0);
        }

        // Student ArrayList'nin 1. Student'ının isminin küçük harfli versiyonunun 1. karakteri
        students.get(1).getName().toLowerCase().charAt(1);

        Student student = students.get(1);
        String name = student.getName();
        String s = name.toLowerCase();
        char c = s.charAt(1);

        // students.get(1).setGrade(50);

        // Object a = System.out.println("Hello, World");

        return Math.sqrt(sum / students.size());
    }

    public double pdf(Student student) {
        double mean = getAverage();
        double stdev = getStdev();

        return (1. / (stdev * Math.sqrt(2 * Math.PI))) * Math.exp(-0.5 * Math.pow((student.getGrade() - mean) / stdev, 2.));
    }

    public boolean contains(Student student) {
        return students.contains(student);
    }

    public int indexOf(Student student) {
        return students.indexOf(student);
    }
}
