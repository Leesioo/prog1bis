package sorting;

import java.util.Comparator;

public class ReverseComparator implements Comparator<Integer> {
    public int compare(Integer integer, Integer t1) {
        if (integer == t1) {
            return 0;
        } else if (integer > t1) {
            return -1;
        } else {
            return 1;
        }

        // można też krócej -> return t1.compareTo(integer);
    }
}
