package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashmapVsArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Ali");
        arrayList.add("Veli");

        // 0: "Ali", 1: "Veli", 3: "Ayşe"
        arrayList.get(0);
        arrayList.set(0, "ali");

        for (int i = 0; i < arrayList.size(); i++) {
            String name = arrayList.get(i);

        }

        for (String name : arrayList) { // name burada value

        }

        // öğrenci ismi: notu
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ali", 90);
        map.put("Veli", 70);

        // "Ali": 90, "Veli": 70, "Ayşe": 90, "Ali": 50, key: value

        System.out.println(map.get("Veli"));

        System.out.println(map.get("Ayşe")); // null
        System.out.println(map.getOrDefault("Ali", -1));
        System.out.println(map.getOrDefault("Ayşe", -1)); // varsa value'ü verir yoksa default verir.

        System.out.println(map.containsKey("Ali"));
        System.out.println(map.containsKey("Ayşe"));
        System.out.println();
        System.out.println(map.containsValue(90));
        System.out.println(map.containsValue(50));
        System.out.println();

        map.put("Hakan", 65);
        map.put("hakan", 50);

        map.replace("Ali", 60);
        System.out.println(map.get("Ali"));
        System.out.println();

        map.remove("hakan"); // Value'u return eder.

        map.putIfAbsent("Hakan", 70);

        if (!map.containsKey("Hakan"))
            map.put("Hakan", 70);

        System.out.println(map.get("Hakan"));

        printMap(map);
    }

    public static void printMap(HashMap<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
