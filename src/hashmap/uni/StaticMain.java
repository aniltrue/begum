package hashmap.uni;

public class StaticMain {
    public static void main(String[] args) {
        Student student1 = new Student("Ali");
        Student student2 = new Student("Veli");
        Student student3 = new Student("Ayşe");

        System.out.println();

        System.out.println(student2.getId()); // 1
        System.out.println(student2.counter); // 3
        System.out.println(Student.counter); // 3
    }
}
