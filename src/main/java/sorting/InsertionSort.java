package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        testString();
    }

    private static void testString() {
        String[] myArray = {"a", "arbuz", "Zenek", "dwa"};

        sortStringByLength(myArray);
        printArray(myArray);
    }

    private static void testInt() {
        int[] myArray = {-8, -1, 3, 4, 2, 9, 0, -5, 100};
        int[] myArraySorted = {6, 5, 4, 3, 2, 1};
        sortInt(myArray);
        printArray(myArray);
//        sortInt(myArraySorted);
//        printArray(myArraySorted);
    }

    public static void sortInt(int[] array) {
        if (array.length < 2)
            return;

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            while ((j >= 0) && (array[j] > actual)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = actual;
        }
    }

    public static void sortStringByLength(String[] array) {
        if (array.length < 2)
            return;

        for (int i = 1; i < array.length; i++) {
            String actual = array[i];
            int j = i - 1;
            while ((j >= 0) && (array[j].length() > actual.length())) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = actual;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
