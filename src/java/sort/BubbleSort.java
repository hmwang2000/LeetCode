package java.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = a.length - 1; j > i; --j) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {

        int a[] = { 49,38,65,97,76,13,27,49};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

} 
