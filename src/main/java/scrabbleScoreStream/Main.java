package scrabbleScoreStream;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        fillScore(mapa, "AEIOULNRST", 1);
        fillScore(mapa, "DG", 2);
        fillScore(mapa, "BCMP", 3);
        fillScore(mapa, "FHVWY", 4);
        fillScore(mapa, "K", 5);
        fillScore(mapa, "JX", 8);
        fillScore(mapa, "QZ", 10);

        System.out.println(countScores(mapa, "cabbage"));
    }

    public static void fillScore(Map<Integer, Integer> myMap, String myString, int points) {
        myString.chars().forEach(c -> myMap.put(c, points));
    }

    public static Integer countScores(Map<Integer, Integer> myMap, String myString) {
        return myString.chars().map(myMap::get).sum();
    }
}
