package classes;

import java.util.ArrayList;

public class University {
    private ArrayList<Course> courses;

    public University() {
        courses = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
