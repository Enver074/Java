package Java_HW_3;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] a = {74, 58, 54, 48, 29, 15, 65, 88, 20};
        int[] b = MergeSort.sortMerge(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
