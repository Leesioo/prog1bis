package zigZag;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(2);
        lista.add(10);
        lista.add(11);
       // System.out.println(zigZag(lista));
        zigZagIterator(lista);
        System.out.println(lista);
    }

    public static void zigZagInPlace(List<Integer> lst) {
        if (lst.size() < 3) return;
        Integer tmp, order = lst.get(1) - lst.get(0);
        if (order == 0) {
            order = 1;
        }
        for (int i = 1; i < lst.size()-1; i++) {
            if ((lst.get(i+1) - lst.get(i)) * order > 0) {
                tmp = lst.get(i);
                lst.set(i, lst.get(i+1));
                lst.set(i+1, tmp);
            }
            order = -order;
        }
    }

    public static void zigZagIterator(List<Integer> lst) {
        if (lst.size() < 3) return;

        ListIterator<Integer> itFirst = lst.listIterator();
        ListIterator<Integer> itSecond = lst.listIterator();
        itSecond.next();
        Integer x, y, order = itSecond.next() - itFirst.next();
        if (order == 0) {
            order = 1;
        }
        while (itSecond.hasNext()) {
            x = itSecond.next();
            y = itFirst.next();
            if ((x - y) * order > 0) {
                itSecond.set(y);
                itFirst.set(x);
            }
            order = -order;
        }
    }

    public static List<Integer> zigZag(List<Integer> inputList) {
        if (inputList.size() < 3) return inputList;
        boolean ascending;
        ascending = inputList.get(0) < inputList.get(1);
        for (int i = 1; i < inputList.size() - 1; i++) {
            if ((ascending && (inputList.get(i) < inputList.get(i + 1))) ||
                    (!ascending && (inputList.get(i) > inputList.get(i + 1)))) {
                Integer temp = inputList.get(i);
                inputList.set(i, inputList.get(i + 1));
                inputList.set(i + 1, temp);
            }
            ascending = !ascending;
        }
        return inputList;
    }
}