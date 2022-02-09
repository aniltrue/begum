package classes;

public class Student {
    public String name;
    public int grade;

    public Student(String name) {
        this.name = name;
        this.grade = 0;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void print() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }
}
