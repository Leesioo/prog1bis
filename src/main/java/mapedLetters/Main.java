package mapedLetters;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(count("laba"));
    }

    public static Map<Character, Integer> count(String str) {
        str = str.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character tmp = str.charAt(i);
            if (map.containsKey(tmp)) {
              map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        return map;
    }
}
