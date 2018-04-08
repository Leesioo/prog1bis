package myList;

public class Main {

    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(5);
        myList.add(0,0);
        myList.add(100,100);
        myList.add(2,2);
        myList.add(3,3);
        myList.add(66,100);
        myList.add(8);
        myList.add(8);
        myList.add(8);
        myList.add(7);
        myList.remove(3);
        myList.print();
        myList.printReverse();
        myList.removeAllByValue(8);
        myList.print();
        myList.printReverse();
    }

}
