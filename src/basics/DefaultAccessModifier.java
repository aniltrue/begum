package basics;

import classes.Course;
import classes.Teacher;

public class DefaultAccessModifier {
    public static void main(String[] args) {
        Course course = new Course("IE343", new Teacher("Ihsan"));
    }
}
