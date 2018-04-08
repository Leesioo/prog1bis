package sorting;

import java.util.Comparator;

public class BubbleSort {
    public static void main(String[] args) {
//        testInt();
        testString();
     }

    private static void testString() {
        String[] myArray = {"a","arbuz","Zenek","dwa"};

        sort(myArray, new LengthOfStringComparator());
        printArray(myArray);
    }

    private static void testInt() {
//        int[] myArray = {-8,-1,3,4,2,9,0,-5,100};
//        int[] myArraySorted = {1,2,3,4,5,6};
//        sortInt(myArray);
//        printArray(myArray);
//        sortInt(myArraySorted);
//        printArray(myArraySorted);

        Integer[] myArray = {-8, -1, 3, 4, 2, 9, 0, -5, 100};
        sort(myArray);
        printArray(myArray);
        sort(myArray, new ReverseComparator());
        printArray(myArray);
    }

    // generyczne, porównujemy normalnie
    public static <T extends Comparable> void sort(T[] array) {
        if (array.length < 2)
            return;
        int rev;
        for (int j = array.length - 2; j >= 0; j--) {
            rev = 0;
            for (int i = 0; i <= j; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    rev++;
                }
            }
            if (rev == 0) return;
        }
    }

    // generyczne, porównywane jak chcemy wg naszego porównywacza (np ReverseComparator z odwróconym porządkiem)
    public static <T> void sort(T[] array, Comparator<T> cmp) {
        if (array.length < 2)
            return;
        int rev;
        for (int j = array.length - 2; j >= 0; j--) {
            rev = 0;
            for (int i = 0; i <= j; i++) {
                if (cmp.compare(array[i], array[i + 1]) > 0) {
                    T tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    rev++;
                }
            }
            if (rev == 0) return;
        }
    }

    public static void sortInt(int[] array) {
        if (array.length < 2)
            return;
        int rev;
        for (int j = array.length - 2; j >= 0; j--) {
            rev = 0;
            for (int i = 0; i <= j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    rev++;
                }
            }
            if (rev == 0) return;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static <T extends Comparable> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
