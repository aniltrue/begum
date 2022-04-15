package week6.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> gradesMap = new HashMap<>();
        gradesMap.put(100, 100);
        gradesMap.put(500, 60);
        gradesMap.put(1000, 70);
        gradesMap.put(2000, 55);

        HashMap<Integer, String> nameMap = new HashMap<>();
        nameMap.put(100, "Ali");
        nameMap.put(500, "Veli");
        nameMap.put(1000, "Ayşe");
        nameMap.put(2000, "Hakan");

        HashMap<String, Integer> nameMap2 = new HashMap<>();
        nameMap2.put("Ali", 100);
        nameMap2.put("Veli", 500);
        nameMap2.put("Ayşe", 1000);
        nameMap2.put("Hakan", 2000);
        nameMap2.put("Fatma", 100);
        nameMap2.put("Hasan", 100);
    }

    public static ArrayList<Student> getStudents(HashMap<Integer, Integer> gradesMap, HashMap<Integer, String> nameMap) {
        ArrayList<Student> students = new ArrayList<>();

        for (Integer id : gradesMap.keySet()) { // 100, 500, 1000, 2000
            int grade = gradesMap.get(id);
            String name = nameMap.get(id);

            Student student = new Student(id, grade, name);

            students.add(student);
        }

        return students;
    }

    public static HashMap<Integer, ArrayList<String>> changeKey(int one, int two) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Ali");
        arr.add("Veli");
        arr.add("Ayşe");
        map.put(100, arr);
        map.put(200, new ArrayList<>());
        map.put(300, new ArrayList<>());

        if (map.containsKey(one)) {
            map.put(two, map.remove(one));
        }

        return map;
    }

    public static HashMap<String, Student> convert(ArrayList<Student> students) {
        HashMap<String, Student> map = new HashMap<>();

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            map.put(student.name, student);
        }

        return map;
    }

    public static ArrayList<Student> getStudents2(HashMap<Integer, Integer> gradesMap, HashMap<String, Integer> nameMap) {
        ArrayList<Student> students = new ArrayList<>();

        HashMap<Integer, String> reversedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }

        for (Integer id : gradesMap.keySet()) { // 100, 500, 1000, 2000, 100, 100
            int grade = gradesMap.get(id);
            String name = reversedMap.get(id);

            String name2 = "";
            ArrayList<String> names = new ArrayList<>();

            for (String key : nameMap.keySet()) {
                if (id.equals(nameMap.get(key))) {
                    name2 = key;
                    names.add(key);
                    // break;
                }
            }

            if (names.size() % 2 == 0) {
                name2 = names.get(1);
            } else {
                name2 = names.get(0);
            }

            Student student = new Student(id, grade, name);

            students.add(student);
        }

        return students;
    }
}
