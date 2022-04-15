package week6.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IntoToHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<>();

        grades.put("Ali", 50);
        grades.put("Veli", 60);

        System.out.println(grades.get("Ali"));

        System.out.println(grades.get("Ayşe"));

        System.out.println(grades.getOrDefault("Ayşe", -1));
        System.out.println(grades.getOrDefault("Ali", -1));

        grades.put("Ali", 70);

        System.out.println(grades.get("Ali"));

        grades.putIfAbsent("Hakan", 80);
        grades.putIfAbsent("Ali", 20);

        System.out.println(grades.get("Hakan"));
        System.out.println(grades.get("Ali"));

        int hakanGrade = grades.remove("Hakan");

        System.out.println(grades.get("Hakan"));

        System.out.println(grades.containsKey("Ali"));
        System.out.println(grades.containsValue(60));

        System.out.println(grades.replace("Ali", 100));

        double sum = 0;

        for (String key : grades.keySet()) {
            sum += grades.get(key);
        }

        System.out.println(sum / grades.size());

        sum = 0;

        for (Integer value : grades.values()) {
            sum += value;
        }

        System.out.println(sum / grades.size());

        sum = 0;

        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            sum += entry.getValue();
            String key = entry.getKey();
        }

        System.out.println(sum / grades.size());

    }
}
