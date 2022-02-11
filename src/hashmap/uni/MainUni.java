package hashmap.uni;

public class MainUni {
    public static void main(String[] args) {
        University university = new University();

        university.add("IE246");
        university.add("IE343");

        Student begum = new Student("Begüm");

        begum.assign(university.getCourse("IE246"));

        begum.addGrade(university.getCourse("IE246"), 90);
        begum.addGrade(university.getCourse("IE246"), 80);

        Student ali = new Student("Ali");

        ali.assign(university.getCourse("IE246"));

        ali.addGrade(university.getCourse("IE246"), 60);
        ali.addGrade(university.getCourse("IE246"), 70);

        Student veli = new Student("Veli");

        veli.assign(university.getCourse("IE246"));

        veli.addGrade(university.getCourse("IE246"), 50);
        veli.addGrade(university.getCourse("IE246"), 70);

        Student ayse = new Student("Ayse");

        ayse.assign(university.getCourse("IE246"));

        for (String key : begum.getGrades().keySet()) {
            System.out.print(key + ": ");

            double sum = 0;

            for (Double grade : begum.getGrades().get(key)) {
                System.out.print(grade + " ");
                sum += grade;
            }

            System.out.println("Total: " + (sum / begum.getGrades().get(key).size()));
        }

        System.out.println(university.getCourse("IE246").getAverage());
    }
}
