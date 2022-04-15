package week6.students;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(124, 10);

        System.out.println(course.getAverage());

        course.setSeed(123);

        System.out.println(course.getAverage());

        course.setN(20);

        System.out.println(course.getAverage());
        System.out.println(course.getStudents().length);
        System.out.println(course.getN());
    }
}
