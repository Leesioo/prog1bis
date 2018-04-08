package heap;

public class Heap {
    private int[] array;
    private int size;

    public Heap(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public Heap(int[] a, int capacity) {
        array = new int[capacity];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
            size++;
        }
        ;
    }

    public int getLeftChild(int i) {
        return 2 * i + 1;
    }

    public int getRightChild(int i) {
        return 2 * i + 2;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

    public int pop() {
        int tmp = array[0];
        size--;
        if (size > 0) {
            array[0] = array[size];
            sifDown();
        }
        return tmp;
    }

    public void add(int i) {
        array[size] = i;
        sifUp(size);
        size++;
    }

    public void sifUp(int index) {
        int parent = getParent(index);
        while ((parent >= 0) && (array[parent] > array[index])) {
            swap(parent, index);
            index = parent;
            parent = getParent(parent);
        }
    }

    public void sifDown() {
        int parent = 0;

        while (true) {
            int left = getLeftChild(parent);
            int right = getRightChild(parent);

            if (left >= size) {
                return;
            } else if (right < size) {
                if (array[right] < array[left]) {
                    if (array[right] < array[parent]) {
                        swap(parent, right);
                        parent = right;
                    }
                } else {
                    if (array[left] < array[parent]) {
                        swap(parent, left);
                        parent = left;
                    }
                }
            } else {
                if (array[left] < array[parent]) {
                    swap(parent, left);
                    parent = left;
                } else {
                    return;
                }
            }
        }
    }

    private void swap(int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < size; i++) {
            temp = temp + "," + array[i];
        }
        return temp;
    }
}
