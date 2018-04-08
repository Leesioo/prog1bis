package myList;

import java.util.ListIterator;

public class MyListIterator implements ListIterator<Integer> {
    private ListNode current;
    private int position;

    public MyListIterator(ListNode first) {
        current = first;
        position = -1;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Integer next() {
        Integer val = current.getValue();
        current = current.getNext();
        position++;
        return val;
    }

    public boolean hasPrevious() {
        return current.getPrevious() != null;
    }

    public Integer previous() {
        current = current.getPrevious();
        position--;
        return current.getValue();
    }

    public int nextIndex() {
        return position+1;
    }

    public int previousIndex() {
        return position-1;
    }

    public void remove() {

    }

    public void set(Integer integer) {
        current.setValue(integer);
    }

    public void add(Integer integer) {

    }
}
