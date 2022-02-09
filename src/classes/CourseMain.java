package classes;

public class CourseMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Erhun");
        Course course = new Course("IE246", teacher);
        course.setTeacher(new Teacher("Ihsan"));

        Student student = new Student("Ali");
        course.add(student);
        course.add(new Student("Veli", 90));

        course.printStudents();

        student.setGrade(50);

        course.printStudents();

        course.get(0).setGrade(75);

        System.out.println(student.getGrade());

        Student veli = course.get(1);
        veli.setGrade(95);
        course.get(0).setGrade(80);

        course.printStudents();

        course.findStudent("Ali").setGrade(70);

        course.print();

        System.out.println(veli.a);
        System.out.println(course.findStudent("Ali").a);
        veli.a = 6;
        System.out.println(student.a);
        System.out.println(Student.a);

        veli.printA();
        Student.printA();
        Student.printA();

        System.out.println();

        System.out.println(student.getId());
        System.out.println(veli.getId());

        Student student2 = new Student("Ayşe");

        System.out.println(student2.getId());
        System.out.println(Student.COUNTER);

        CourseMain main = new CourseMain();
        main.print();

        // main.main(args);
    }

    public void print() {
        System.out.println("Hello World");
    }
}
