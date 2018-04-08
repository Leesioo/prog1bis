package addingLists;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> myFirstList = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, 5, 6, 8, 56, 67, 88}));
        List<Integer> mySecondList = new LinkedList<>(Arrays.asList(new Integer[]{4, 101, 104, 107, 111, 145, 149}));

        System.out.println(addTwoLists(myFirstList, mySecondList));
        System.out.println(merge(myFirstList, mySecondList));
    }

    public static List<Integer> merge(List<Integer> first, List<Integer> second) {
        List<Integer> result = new ArrayList<>(first.size() + second.size());
        int i = 0, j = 0;
        Integer x, y;
        while (i < first.size() && j < second.size()) {
            x = first.get(i);
            y = second.get(j);
            if (x < y) {
                result.add(x);
                i++;
            } else {
                result.add(y);
                j++;
            }
        }
        while (i < first.size()) {
            result.add(first.get(i));
            i++;
        }
        while (j < second.size()) {
            result.add(second.get(j));
            j++;
        }

        return result;
    }

    public static List<Integer> mergeIterator(List<Integer> first, List<Integer> second) {
        ListIterator<Integer> it1 = first.listIterator();
        ListIterator<Integer> it2 = second.listIterator();
        LinkedList<Integer> out = new LinkedList<>();
        Integer x = it1.next(), y = it2.next();

        while (x != null && y != null) {
            if (x < y) {
                out.add(x);
                x = it1.hasNext() ? it1.next() : null;
            } else {
                out.add(y);
                y = it2.hasNext() ? it2.next() : null;
            }
        }

        if (x != null) {
            out.add(x);
        }
        if (y != null) {
            out.add(y);
        }

        it1.forEachRemaining(i -> out.add(i));
        it2.forEachRemaining(i -> out.add(i));

        return out;
    }

    public static List<Integer> addTwoLists(List<Integer> first, List<Integer> second) {
        ListIterator<Integer> it1 = first.listIterator();
        ListIterator<Integer> it2 = second.listIterator();
        LinkedList<Integer> out = new LinkedList<>();
        Integer x = null, y = null;

        while (it1.hasNext() && it2.hasNext()) {
            if (x == null) {
                x = it1.next();
            }
            if (y == null) {
                y = it2.next();
            }
            if (x < y) {
                out.add(x);
                x = null;
            } else {
                out.add(y);
                y = null;
            }
        }
        if (x != null) {
            out.add(x);
        }
        if (y != null) {
            out.add(y);
        }
        it1.forEachRemaining(i -> out.add(i));
        it2.forEachRemaining(i -> out.add(i));

//        while (it1.hasNext() || it2.hasNext()) {
//            if (it1.hasNext() && it2.hasNext()) {
//                Integer x = it1.next();
//                Integer y = it2.next();
//                if (x < y) {
//                    out.add(x);
//                    it2.previous();
//                } else {
//                    out.add(y);
//                    it1.previous();
//                }
//            } else if (it1.hasNext()) {
//                out.add(it1.next());
//            } else {
//                out.add(it2.next());
//            }
//        }

        return out;
    }
}
