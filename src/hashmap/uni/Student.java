package hashmap.uni;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    public static int counter = 0;

    private String name;
    private int id = 0;

    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<String, ArrayList<Double>> grades = new HashMap<>();
    // "IE246": {90, 80}

    public Student(String name) {
        // System.out.println(name + "(önce): " + id + " " + counter);

        this.name = name;
        this.id = counter++;
        // counter = counter + 1; // counter++

        // System.out.println(name + "(sonra): " + id + " " + counter);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public HashMap<String, Course> getCourses() {
        return courses;
    }

    public HashMap<String, ArrayList<Double>> getGrades() {
        return grades;
    }

    public void assign(Course course) {
        courses.put(course.getName(), course);

        course.getStudents().add(this);
    }

    public void addGrade(Course course, double grade) {
        grades.putIfAbsent(course.getName(), new ArrayList<>());

        grades.get(course.getName()).add(grade);
    }
}
