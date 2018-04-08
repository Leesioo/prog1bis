package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        //testInt();
        testString();
    }

    private static void testInt() {
        int[] myArray = {-8,-1,3,4,2,9,0,-5,100};

        sortInt(myArray);
        printArray(myArray);
    }

    private static void testString() {
        String[] myArray = {"a","arbuz","Zenek","dwa"};

        sortString(myArray);
        printArray(myArray);
    }

    public static void sortInt(int[] array) {
        if (array.length < 2)
            return;
        int minIndex = 0;
        for (int i = 0; i < array.length-1; i++) {
            minIndex = findMinIndex(array, i);
            if (i != minIndex) {
                int tmpValue = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmpValue;
            }
        }
    }

    public static int findMinIndex(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start+1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sortString(String[] array) {
        if (array.length < 2)
            return;
        int minIndex = 0;
        for (int i = 0; i < array.length-1; i++) {
            minIndex = findMinLength(array, i);
            if (i != minIndex) {
                String tmpValue = array[i];
                array[i] = array[minIndex];
                for (int j = minIndex; j > i; j--) {
                    array[j] = array[j-1];
                }
                array[i+1] = tmpValue;
            }
        }
    }

    public static int findMinLength(String[] array, int start) {
        int minIndex = start;
        int minValue = array[start].length();
        for (int i = start+1; i < array.length; i++) {
            if (array[i].length() < minValue) {
                minValue = array[i].length();
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
