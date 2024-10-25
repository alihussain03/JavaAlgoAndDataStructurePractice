package com.Sorting;

import com.util.ArrayUtil;

public class BubbleSortUsingRecursion {

    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        bubbleSortUsingRecursion(array, array.length - 1, 0);
        ArrayUtil.printArray(array);

        array = new int[]{13, 46, 24, 52, 20, 9};
        bubbleSortUsingRecursion2(array, array.length);
        ArrayUtil.printArray(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     */
    static void bubbleSortUsingRecursion(int[] array, int i, int j) {
        if (i == 0) return;
        if (j < i) {
            if (array[j] > array[j + 1]) {
                ArrayUtil.swap(array, j, j + 1);
            }
            bubbleSortUsingRecursion(array, i, j + 1);
        } else bubbleSortUsingRecursion(array, --i, 0);
    }

    static void bubbleSortUsingRecursion2(int[] array, int n) {
        if (n == 1) return;
        boolean swapped = false;
        for (int i = 0; i <= n - 2; i++) {
            if (array[i] > array[i + 1]) {
                ArrayUtil.swap(array, i, i + 1);
                swapped = true;
            }
        }
        if (!swapped) return;
        bubbleSortUsingRecursion2(array, n - 1);
    }
}
