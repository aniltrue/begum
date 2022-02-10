package hashmap;

public class Student {
    public static int COUNTER = 0;

    private String name;
    private int id;

    public Student(String name) {
        this.name = name;
        id = COUNTER++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
