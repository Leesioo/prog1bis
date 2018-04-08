package myList;

import java.util.Iterator;

public class MyList implements Iterable<Integer>{
    private ListNode first;
    private ListNode last;
    private int count;

    @Override
    public Iterator<Integer> iterator() {
        return new MyListIterator(first);
    }

    public void add(Integer value) {
       ListNode node = new ListNode(value);
       if (first == null) {
           first = node;
           last = node;
       } else {
           last.setNext(node);
           node.setPrevious(last);
           last = node;
       }
       count++;
    }

    @Override
    public String toString() {
        String res;
        if (first == null) {
            res = "Pusta lista";
            return res;
        }
        ListNode tmp = first;
        res = "Elementy listy:";
        while (tmp.getNext() != null) {
            res += " " + tmp.getValue();
            tmp = tmp.getNext();
        }
        res += " " + tmp.getValue();
        return res;
    }

    public void print() {
        if (first == null) {
            System.out.println("Pusta lista");
            return;
        }
        ListNode tmp = first;
        System.out.println("Elementy listy:");
        while (tmp.getNext() != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
        System.out.println(tmp.getValue());
        return;
    }

    public void printReverse() {
        if (first == null) {
            System.out.println("Pusta lista");
            return;
        }
        ListNode tmp = last;
        System.out.println("Elementy listy:");
        while (tmp.getPrevious() != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.getPrevious();
        }
        System.out.println(tmp.getValue());
        return;
    }

    public void add(Integer value, int position) {
        if (count < position) {
            add(value);
            return;
        }
        ListNode node = new ListNode(value);
        count++;
        if (position <= 0) {
            node.setNext(first);
            first.setPrevious(node);
            first = node;
            return;
        }
        ListNode tmp = getNode(position-1);
        node.setNext(tmp.getNext());
        tmp.setNext(node);
        node.setPrevious(tmp);
        node.getNext().setPrevious(node);
    }

    private ListNode getNode(int position) {
        if ((count-1 < position) || (position < 0)) {
            throw new IndexOutOfBoundsException("Błędna pozycja") ;
        }
        ListNode tmp = first;
        for (int i = 0; i < position; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public Integer get(int position) {
        ListNode node = getNode(position);
        return node.getValue();
    }

    public void set(Integer value, int position) {
        ListNode node = getNode(position);
        node.setValue(value);
    }

    public void remove(int position) {
        if ((count-1 < position) || (position < 0)) {
            throw new IndexOutOfBoundsException("Błędna pozycja") ;
        }
        if (position == 0) {
            first = first.getNext();
            first.setPrevious(null);
            count--;
            if (count == 0) {
                last = first;
            }
            return;
        }
        if (position == count-1) {
            ListNode node = getNode(position-1);
            node.setNext(null);
            last = node;
            count--;
            return;
        }
        ListNode node = getNode(position-1);
        node.setNext(getNode(position).getNext());
        node.getNext().setPrevious(node);
        count--;
        return;
    }

    private void remove(ListNode temp) {
        if (temp.getPrevious() != null) {
            temp.getPrevious().setNext(temp.getNext());
        }
        if (temp.getNext() != null) {
            temp.getNext().setPrevious(temp.getPrevious());
        }
        return;
    }

    public void removeByValue(Integer value) {
        ListNode tmp = first;
        int position = 0;
        while (tmp != null) {
            if (tmp.getValue() == value) {
                remove(tmp);
                return;
            }
        }
    }

    public void removeAllByValue(Integer value) {
        ListNode tmp = first;
        int position = 0;
        while (tmp != null) {
            if (tmp.getValue() == value) {
                remove(tmp);
                position--;
            }
            position++;
            tmp = tmp.getNext();
        }
    }

    public int size() {
        return count;
    }

    public void clear() {
        first = null;
        last = null;
    }
}
