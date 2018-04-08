package binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
        generateTree(myTree);
//        generateTreeWithPrint();
//        containsValues(myTree);
        myTree.print();
        myTree.delete(5, myTree.getRoot(), null);
        myTree.print();
    }

    private static void containsValues(BinarySearchTree myTree) {
        System.out.println(myTree.contains(10));
        System.out.println(myTree.contains(5));
        System.out.println(myTree.contains(2));
        System.out.println(myTree.contains(666));
    }

    private static void generateTreeWithPrint() {
        //        System.out.println(myTree.add(5));
//        System.out.println(myTree.add(1));
//        System.out.println(myTree.add(6));
//        System.out.println(myTree.add(10));
//        System.out.println(myTree.add(9));
//        System.out.println(myTree.add(2));
//        System.out.println(myTree.add(10));
    }

    private static void generateTree(BinarySearchTree myTree) {
        myTree.add(5);
        myTree.add(1);
        myTree.add(6);
        myTree.add(-3);
        myTree.add(2);
        myTree.add(10);
        myTree.add(-5);
        myTree.add(-1);
        myTree.add(8);
        myTree.add(11);
        myTree.add(-2);
        myTree.add(9);
    }
}
