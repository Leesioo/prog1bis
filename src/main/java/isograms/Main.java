package isograms;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(isIsogram("Isogrami"));
    }

    public static boolean isIsogram(String str) {
        Set<Character> mySet = new HashSet<>();
        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            Character tmp = str.charAt(i);
            if ((tmp >= 'A') && (tmp <= 'Z')) {
                if (mySet.contains(tmp)) {
                    return false;
                } else {
                    mySet.add(tmp);
                }
            } else if ( !((tmp == '-') || (tmp == ' '))) {
                return false;
            }
        }
        return true;
    }
}
