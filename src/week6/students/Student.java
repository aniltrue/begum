package week6.students;

public class Student {
    private int id, grade;
    public String name;

    public Student(int id, int grade) {
        this.id = id;
        this.grade = grade;
    }

    public Student(int id, int grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }
}
