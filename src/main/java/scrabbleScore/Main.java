package scrabbleScore;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> mapa = new HashMap<Character, Integer>();

        mapa = mapBuilder(mapa);

        System.out.println(wordValue(mapa, "cabbage"));
    }

    private static Map<Character, Integer> mapBuilder(Map<Character, Integer> mapa) {
        String temp = "AEIOULNRST";
        for (int i = 0; i < temp.length(); i++) {
            mapa.put(temp.charAt(i), 1);
        }
        temp = "DG";
        for (int i = 0; i < temp.length(); i++) {
            mapa.put(temp.charAt(i), 2);
        }
        temp = "BCMP";
        for (int i = 0; i < temp.length(); i++) {
            mapa.put(temp.charAt(i), 3);
        }
        temp = "FHVWY";
        for (int i = 0; i < temp.length(); i++) {
            mapa.put(temp.charAt(i), 4);
        }
        temp = "K";
        for (int i = 0; i < temp.length(); i++) {
            mapa.put(temp.charAt(i), 5);
        }
        temp = "JX";
        for (int i = 0; i < temp.length(); i++) {
            mapa.put(temp.charAt(i), 8);
        }
        temp = "QZ";
        for (int i = 0; i < temp.length(); i++) {
            mapa.put(temp.charAt(i), 10);
        }
        return mapa;
    }

    public static int wordValue(Map<Character, Integer> myMap, String myString) {
        Integer returnValue = 0;
        myString = myString.toUpperCase();
        for (int i = 0; i < myString.length(); i++) {
            returnValue += myMap.get(myString.charAt(i));
        }

        return returnValue;
    }
}
