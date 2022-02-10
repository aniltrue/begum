package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExample2 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        ArrayList<Matching> matchings = new ArrayList<>();
        Matching matching = new Matching("fb", "gs", 3, 1);
        matchings.add(matching);


        matchings.add(new Matching("FB", "GS", 3, 2));
        matchings.add(new Matching("BJK", "GS", 2, 1));
        matchings.add(new Matching("BJK", "FB", 2, 2));
        matchings.add(new Matching("TS", "GS", 1, 2));
        matchings.add(new Matching("BJK", "TS", 2, 1));


        // "FB": {3, 2}, "GS": {2, 1, 2}, ...

        HashMap<String, Integer> totalScores;
    }

    public static HashMap<String, ArrayList<Integer>> getScores(ArrayList<Matching> matchings) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (Matching matching : matchings) {
            if (!map.containsKey(matching.team1))
                map.put(matching.team1, new ArrayList<>());

            map.putIfAbsent(matching.team2, new ArrayList<>());

            map.get(matching.team1).add(matching.team1Score);
            map.get(matching.team2).add(matching.team2Score);
        }

        return map;
    }

    public static void printDiv(HashMap<String, Integer> map) {
        /*
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i == j)
                    continue;

                if (arr.get(i) % arr.get(j) == 0) {
                    System.out.println(i + " " + j);
                }
            }
        }
         */

        for (String key1 : map.keySet()) {
            for (String key2 : map.keySet()) {
                if (key1.equals(key2))
                    continue;

                if (map.get(key1) % map.get(key2) == 0) {
                    System.out.println(key1 + " " + key2);
                }
            }
        }
    }

    public static void change(HashMap<String, Integer> map, String str) {
        if (map.containsKey(str))
            map.replace(str, map.get(str) + 1);
    }

    public HashMap<String, Integer> sumScores(HashMap<String, ArrayList<Integer>> map) {
        HashMap<String, Integer> totalScores = new HashMap<>();

        for (String key : map.keySet()) {
            int sum = 0;

            for (int score : map.get(key)) {
                sum += score;
            }

            totalScores.put(key, sum);
        }

        return totalScores;
    }

    static class Matching {
        public String team1, team2;
        public int team1Score, team2Score;

        public Matching(String t1, String t2, int s1, int s2) {
            team1 = t1;
            team2 = t2;
            team1Score = s1;
            team2Score = s2;
        }
    }
}
