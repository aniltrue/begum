package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ali"));
        students.add(new Student("Veli"));
        students.add(new Student("Ayşe"));

        HashMap<String, Student> studentMap = getStudentMap(students); // key: student name, value: student object

        HashMap<Integer, Student> idMap = convertIDMap(studentMap);

        for (Student value : idMap.values()) {
            System.out.println(value.getName());
        }
    }

    public static HashMap<String, Student> getStudentMap(ArrayList<Student> students) {
        HashMap<String, Student> map = new HashMap<>();

        for (Student student : students) {
            map.putIfAbsent(student.getName(), student);
        }

        return map;
    }

    public static HashMap<Integer, Student> convertIDMap(HashMap<String, Student> studentMap) {
        HashMap<Integer, Student> map = new HashMap<>();

        for (String key : studentMap.keySet()) {
            map.put(studentMap.get(key).getId(), studentMap.get(key));
        }

        return map;
    }
}
