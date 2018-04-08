package sorting;

import java.util.ArrayList;

public class BucketSort {
    public static void main(String[] args) {
        testInt();
    }

    private static void testInt() {
        int[] myArray = {1, 2, 3, 1, 2, 4, 0, 2, 0};
//        int[] myArraySorted = {1, 2, 3, 4, 5, 6};
//        sortInt(myArray, 0, myArray.length - 1);
        sortInt(myArray, 5);
        printArray(myArray);
//        sortInt(myArraySorted, 0, myArraySorted.length-1);
//        printArray(myArraySorted);
    }

    public static void sortInt(int[] array, int buckets) {
        ArrayList<ArrayList<Integer>> myList = new ArrayList<>();
        for (int i = 0; i < buckets; i++) {
            myList.add(new ArrayList<>(i));
        }
        for (int i = 0; i < array.length; i++) {
            myList.get(array[i]).add(array[i]);
        }
        int k = 0;
        for (int i = 0; i < buckets; i++) {
            for (int j = 0; j < myList.get(i).size(); j++) {
                array[k] = myList.get(i).get(j);
                k++;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
