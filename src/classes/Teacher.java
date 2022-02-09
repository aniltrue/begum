package classes;

import java.util.ArrayList;

public class Teacher {
    private String name;
    private ArrayList<Course> courses;

    public Teacher(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    void addCourse(Course course) {
        courses.add(course);
    }
}
