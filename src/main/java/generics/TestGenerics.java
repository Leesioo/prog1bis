package generics;

public class TestGenerics {

    public static void main(String[] args) {
        foo("test");
    }

    public static <T extends Comparable<T>> void foo(T arg) {
        System.out.println(arg);
    }
}
