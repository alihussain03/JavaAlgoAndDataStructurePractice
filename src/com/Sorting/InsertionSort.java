package com.Sorting;

import util.CollectionUtil;

/* one element at a time by repeatedly taking the next unsorted element and inserting it into its correct
position within the already sorted portion of the array. */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        insertionSort(array);
        array = new int[]{13, 46, 24, 52, 20, 9};
        insertionSortWhileLoop(array);
        array = new int[]{13, 46, 24, 52, 20, 9};
        insertionSortSwap(array);

        array = new int[]{13, 46, 24, 52, 20, 9};
        System.out.print("\nInsertion sort using recursion: ");
        insertionSortUsingRecursion(array, 1);
        CollectionUtil.printArray(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     */
    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            int key = array[i]; // The element to be inserted

            for (j = i - 1; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
        System.out.print("Insertion sort: ");
        CollectionUtil.printArray(array);
    }

    static void insertionSortWhileLoop(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; // The element to be inserted
            int j = i - 1;

            // Move elements greater than 'key' to one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Insert 'key' into the correct position
            array[j + 1] = key;
        }
        System.out.print("\nInsertion sort: ");
        CollectionUtil.printArray(array);
    }

    static void insertionSortSwap(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;

            // Keep swapping until the current element is in the correct position
            while (j >= 0 && array[j + 1] < array[j]) {
                CollectionUtil.swapArrayElements(array, j + 1, j);
                j--;
            }
        }
        System.out.print("\nInsertion sort using swapping: ");
        CollectionUtil.printArray(array);
    }

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
