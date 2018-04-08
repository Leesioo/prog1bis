package noDuplicates;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 1, 2, 1});
        System.out.println(noDuplicates(list));
// tutaj przy użyciu strumienia
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }

    public static List<Integer> noDuplicates(List<Integer> myList) {
        List<Integer> tempList = new LinkedList<>();
        Set<Integer> tempSet = new HashSet<>();

//        for (int i = 0; i < myList.size(); i++) {
//            if (!tempSet.contains(myList.get(i))) {
//                tempList.add(myList.get(i));
//                tempSet.add(myList.get(i));
//            }
//        }

        // ta pętla jest bardziej efektywna
        for (Integer elem: myList) {
            if (!tempSet.contains(elem)) {
                tempList.add(elem);
                tempSet.add(elem);
            }
        }

        return tempList;
    }
}
