package iterators;

import java.util.*;

public class Iterators {
    public static void main(String[] args) {
        List<Integer> lst = new LinkedList<>(Arrays.asList(new Integer[] {5,2,1,3,4,5,2,0}));
        Iterator<Integer> iter = lst.iterator();
        ListIterator<Integer> li = lst.listIterator();
        while (iter.hasNext()) {
           // System.out.println(iter.next());
            int x = iter.next();
            if (x > 4) {
                iter.remove();
            }
        }
        System.out.println(lst);
    }
}
