package week6.students;

import java.util.Random;

public class Course {
    private int seed;
    private int n;
    private Random random;
    private Student[] students;

    public Course(int seed, int n) {
        this.seed = seed;
        this.n = n;

        random = new Random(seed);

        initiate();
    }

    private void initiate() {
        random.setSeed(seed);

        students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student(i, random.nextInt(101));
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;

        initiate();
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;

        initiate();
    }

    public Student[] getStudents() {
        return students;
    }

    public Random getRandom() {
        return random;
    }

    public double getAverage() {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += students[i].getGrade();
        }

        return sum / n;
    }
}
