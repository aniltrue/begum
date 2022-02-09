package classes;

public class Student {
    public static int COUNTER = 0;

    public static int a = 5;

    private String name;
    private int grade;
    private int id;

    public Student(String name) {
        this.name = name;
        this.grade = 0;
        this.id = COUNTER++;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.id = COUNTER;
        COUNTER += 1;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void print() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }

    public static void printA() {
        System.out.println(a);
    }
}
