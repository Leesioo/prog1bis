package sorting;

import java.lang.reflect.Array;

public class MergeSort {

    public static void main(String[] args) {
        testInt();
    }

    private static void testInt() {
//        int[] myArray = {-8, -1, 3, 4, 2, 9, 0, -5, 100};
//        int[] myArraySorted = {1, 2, 3, 4, 5, 6};
//        sortInt(myArray, 0, myArray.length - 1);
//        myArray = sortInt(myArray);
//        printArray(myArray);
//        sortInt(myArraySorted, 0, myArraySorted.length-1);
//        printArray(myArraySorted);

        Integer[] myArray = {-8, -1, 3, 4, 2, 9, 0, -5, 100, 666};
        sort(myArray,0, myArray.length-1);
        printArray(myArray);
    }

    public static int[] sortInt(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int l = array.length / 2;
        int[] left = new int[l];
        int[] right = new int[array.length - l];

        for (int i = 0; i < l; i++) {
            left[i] = array[i];
        }

        for (int i = l; i < array.length; i++) {
            right[i-l] = array[i];
        }

        return merge(sortInt(left), sortInt(right));
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] wynik = new int[a1.length + a2.length];
        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                wynik[k] = a1[i];
                i++;
            } else {
                wynik[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < a1.length) {
            wynik[k] = a1[i];
            i++;
            k++;
        }
        while (j < a2.length) {
            wynik[k] = a2[j];
            j++;
            k++;
        }

        return wynik;
    }


    public static void sortInt(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sortInt(array, start, middle);
            sortInt(array, middle + 1, end);

            merge(array, start, middle, end);
        }
    }

    public static void merge(int array[], int start, int middle, int end) {
        int leftLength = middle - start + 1;
        int rigthLength = end - middle;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rigthLength];

        for (int i = 0; i < leftLength; ++i)
            leftArray[i] = array[start + i];
        for (int j = 0; j < rigthLength; ++j)
            rightArray[j] = array[middle + 1 + j];

        int i = 0;
        int j = 0;

        int k = start;
        while (i < leftLength && j < rigthLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rigthLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static <T extends Comparable<T>> void sort(T[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(array, start, middle);
            sort(array, middle + 1, end);

            merge(array, start, middle, end);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] array, int start, int middle, int end) {
        int leftLength = middle - start + 1;
        int rigthLength = end - middle;

        Object[] leftArray = new Object[leftLength];
        Object[] rightArray = new Object[rigthLength];

        for (int i = 0; i < leftLength; ++i)
            leftArray[i] = array[start + i];
        for (int j = 0; j < rigthLength; ++j)
            rightArray[j] = array[middle + 1 + j];

        int i = 0;
        int j = 0;

        int k = start;
        while (i < leftLength && j < rigthLength) {
            if (((T)leftArray[i]).compareTo((T)rightArray[j]) <= 0) {
                array[k] = (T)leftArray[i];
                i++;
            } else {
                array[k] = (T)rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = (T)leftArray[i];
            i++;
            k++;
        }

        while (j < rigthLength) {
            array[k] = (T)rightArray[j];
            j++;
            k++;
        }
    }

    public static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
