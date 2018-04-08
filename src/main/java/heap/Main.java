package heap;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {2,4,6,5,7,8,30,10};
        Heap myHeap = new Heap(myArray, 100);
        System.out.println(myHeap);
        myHeap.add(1);
        System.out.println(myHeap);
        myHeap.pop();
        System.out.println(myHeap);
    }
}
