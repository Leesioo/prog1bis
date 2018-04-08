package binarySearchTree;

import java.util.HashSet;
import java.util.Stack;

public class BinarySearchTree {
    private BSTNode root;

    public BSTNode getRoot() {
        return root;
    }

    public BinarySearchTree() {
        root = null;
    }

    public boolean add(int i) {
        if (root == null) {
            root = new BSTNode(i);
            return true;
        }
        BSTNode x = root, y = null;
        while (x != null) {
            y = x;
            if (i == x.getValue()) {
                return false;
            }
            if (i > x.getValue()) {
                x = x.getRight();
            } else {
                x = x.getLeft();
            }
        }
        if (i > y.getValue()) {
            y.setRight(new BSTNode(i));
        } else {
            y.setLeft(new BSTNode(i));
        }
        return true;
    }

    public boolean contains(int i) {
        if (root == null) {
            return false;
        }
        BSTNode x = root, y = null;
        while (x != null) {
            y = x;
            if (i == x.getValue()) {
                return true;
            }
            if (i > x.getValue()) {
                x = x.getRight();
            } else {
                x = x.getLeft();
            }
        }
        return false;
    }

    public void print() {
        if (root == null) {
            System.out.println("Drzewo jest puste");
            return;
        }
        Stack<BSTNode> myStack = new Stack();
        BSTNode x = root;
        HashSet<BSTNode> printed = new HashSet<>();
        myStack.push(x);
        while (!myStack.isEmpty()) {
            x = myStack.pop();
            if (!printed.contains(x)) {
                if ((x.getLeft() != null) && (!printed.contains(x.getLeft()))) {
                    while (x.getLeft() != null) {
                        myStack.push(x);
                        x = x.getLeft();
                    }
                    System.out.println(x.getValue());
                    printed.add(x);
                } else {
                    System.out.println(x.getValue());
                    printed.add(x);
                }
            }
            if (x.getRight() != null) {
                myStack.push(x.getRight());
            }
        }
    }

    private BSTNode findMin(BSTNode first) {
        BSTNode tmp = first;
        while (tmp.getLeft() != null)
            tmp = tmp.getLeft();
        return tmp;
    }

    public boolean delete(int i, BSTNode first, BSTNode parent) {
        if (first == null) {
            return false;
        }
        BSTNode x = first, y = parent;
        boolean exists = false;
        while ((x != null) && (!exists)) {

            if (i == x.getValue()) {
                exists = true;
            } else {
                y = x;
                if (i > x.getValue()) {
                    x = x.getRight();
                } else {
                    x = x.getLeft();
                }
            }
        }
        if (!exists) {
            return false;
        }

        if ((x.getLeft() == null) && (x.getRight() == null)) {
            if (y.getValue() > x.getValue()) {
                y.setLeft(null);
            } else {
                y.setRight(null);
            }
            return true;
        }
        if ((x.getLeft() == null) || (x.getRight() == null)) {
            if (y.getValue() > x.getValue()) {
                y.setLeft(x.getLeft() == null ? x.getRight() : x.getLeft());
            } else {
                y.setRight(x.getLeft() == null ? x.getRight() : x.getLeft());
            }
            return true;
        }

        BSTNode min = new BSTNode(0);
        min.setValue(findMin(x.getRight()).getValue());
        min.setRight(x.getRight());
        min.setLeft(x.getLeft());
        if (y != null) {
        if (y.getValue() > x.getValue()) {
            y.setLeft(min);
        } else {
            y.setRight(min);
        }}
        else {
            root = min;
        }
        delete(min.getValue(), x.getRight(), min);
        return true;
    }
}
