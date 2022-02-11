package hashmap.uni;

import java.util.ArrayList;

public class Course {
    private ArrayList<Student> students = new ArrayList<>();
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void assign(Student student) {
        students.add(student);

        student.getCourses().put(name, this);
    }

    public double getAverage() {
        double sum = 0;
        int counter = 0;

        for (Student student : students) {
            ArrayList<Double> studentGrades = student.getGrades().getOrDefault(name, new ArrayList<>());

            double sumStudent = 0;

            for (Double grade : studentGrades) {
                sumStudent += grade;
            }

            double avgStudent = sumStudent / studentGrades.size();

            if (studentGrades.size() > 0) {
                sum += avgStudent;
                counter++;
            }
        }

        return sum / counter;
    }
}
