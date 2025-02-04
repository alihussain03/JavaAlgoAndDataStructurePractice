package com.Sorting;


import com.util.CollectionUtil;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        selectionSort(array);
        array = new int[]{13, 46, 24, 52, 20, 9};
        selectionSort2(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     */
    static void selectionSort(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (array[j] < array[i]) {
                    CollectionUtil.swapArrayElements(array, i, j);
                }
            }
        }
        System.out.print("Selection sort: ");
        CollectionUtil.printArray(array);
    }

    static void selectionSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Update index of minimum element
                }
            }

            // Swap the found minimum element with the first unsorted element
            if (minIndex != i) {
                CollectionUtil.swapArrayElements(array, i, minIndex);
            }
        }

        System.out.print("Selection sort: ");
        CollectionUtil.printArray(array);
    }
}
