package myList;

public class ListNode {
    private Integer value;
    private ListNode next;
    private ListNode previous;

    public ListNode(Integer value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public ListNode(Integer value, ListNode next, ListNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }
}
