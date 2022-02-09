package classes;

public class CourseMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Erhun");
        Course course = new Course("IE246", teacher);

        Student student = new Student("Ali");
        course.students.add(student);
        course.students.add(new Student("Veli", 90));

        course.printStudents();

        student.grade = 50;

        course.printStudents();

        course.students.get(0).grade = 75;

        System.out.println(student.grade);

        Student veli = course.students.get(1);
        veli.grade = 95;
        course.students.get(0).grade = 80;

        course.printStudents();

        course.findStudent("Ali").grade = 50;

        course.printStudents();
    }
}
