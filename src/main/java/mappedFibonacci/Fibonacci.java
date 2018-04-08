package mappedFibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer, Integer> seen;

    public Fibonacci() {
        seen = new HashMap<>();
        seen.put(1,1);
        seen.put(2,1);
    }

    public Integer get(Integer n) {
        if (seen.containsKey(n)) {
            return seen.get(n);
        }
        Integer fib = get(n-1) + get(n-2);
        seen.put(n, fib);
        return fib;
    }
}
