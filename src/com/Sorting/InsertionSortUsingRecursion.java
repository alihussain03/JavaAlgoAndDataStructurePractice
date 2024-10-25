package com.Sorting;

import com.util.ArrayUtil;

public class InsertionSortUsingRecursion {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        insertionSortUsingRecursion(array, 1);
        ArrayUtil.printArray(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     */
    static void insertionSortUsingRecursion(int[] array, int i) {
        if (i == array.length) return;
        int key = array[i];
        int j = i - 1;

        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = key;
        insertionSortUsingRecursion(array, i + 1);
    }
}
