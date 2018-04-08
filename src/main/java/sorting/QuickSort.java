package sorting;

public class QuickSort {

    public static void main(String[] args) {
        testInt();
    }

    private static void testInt() {
        int[] myArray = {-8, -1, 3, 4, 2, 9, 0, -5, 100};
//        int[] myArray = {0, -3, 4, 5, 1, 2};
//        split(myArray, 0, 5);
//        int[] myArraySorted = {1, 2, 3, 4, 5, 6};

        sortInt2(myArray, 0, myArray.length - 1);
        printArray(myArray);

//        sortInt(myArraySorted, 0, myArraySorted.length-1);
//        printArray(myArraySorted);
    }

    public static void sortInt(int[] array, int start, int end) {
        if (start < end) {
            int i = divideTable(array, start, end);
            sortInt(array, start, i - 1);
            sortInt(array, i + 1, end);
        }
    }

    public static void sortInt2(int[] array, int start, int end) {
        if (start < end) {
            int i = split(array, start, end);
            sortInt(array, start, i - 1);
            sortInt(array, i + 1, end);
        }
    }

    public static int split(int[] array, int start, int stop) {
        int pivot = array[stop];
        int l = start, h = stop-1;
        while (l < h) {
            while ((l < stop) && (array[l] < pivot)) {
                l++;
            }
            while ((h >= start) && (array[h] > pivot)) {
                h--;
            }
            if (l < h) {
                changeElements(array, l, h);
                l++;
                h--;
            }
        }
        if (h <= l) {
            changeElements(array, l, stop);
        }
        return h+1;
    }

    public static int divideTable(int[] array, int start, int end) {
        int point = chooseDivPoint(start, end);
        int value = array[point];
        if (point != end) {
            changeElements(array, point, end);
        }
        point = start;

        for (int i = start; i < end; i++) {
            if (array[i] < value) {
                if (i != point) {
                    changeElements(array, i, point);
                }
                point++;
            }
        }
        if (point != end) {
            changeElements(array, point, end);
        }
        return point;
    }

    public static int chooseDivPoint(int first, int last) {
        return first + (last - first) / 2;
    }

    public static void changeElements(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    public static int split(int[] array) {
        int pivot = array[array.length-1];
        int l = 0, h = array.length-2;
        while (l < h) {
            while ((l < array.length) && (array[l] < pivot)) {
                l++;
            }
            while ((h >= 0) && (array[h] > pivot)) {
                h--;
            }
            if (l < h) {
                changeElements(array, l, h);
                l++;
                h--;
            }
        }
        if (h <= l) {
            changeElements(array, l, array.length-1);
        }
        return h+1;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
