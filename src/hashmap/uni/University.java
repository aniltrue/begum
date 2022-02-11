package hashmap.uni;

import java.util.ArrayList;
import java.util.HashMap;

public class University {
    private HashMap<String, Course> courses = new HashMap<>();

    public void add(String courseName) {
        courses.put(courseName, new Course(courseName));
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> result = new ArrayList<>();

        for (Course value : courses.values())
            result.add(value);

        return result;
    }

    public Course getCourse(String name) {
        return courses.get(name);
    }
}
