package com.Sorting;

import com.util.ArrayUtil;

/* one element at a time by repeatedly taking the next unsorted element and inserting it into its correct
position within the already sorted portion of the array. */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        insertionSort(array);
        array = new int[]{13, 46, 24, 52, 20, 9};
        insertionSort2(array);
        array = new int[]{13, 46, 24, 52, 20, 9};
        insertionSort3(array);
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
        ArrayUtil.printArray(array);
    }

    static void insertionSort2(int[] array) {
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
        System.out.print("Insertion sort: ");
        ArrayUtil.printArray(array);
    }

    static void insertionSort3(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;

            // Keep swapping until the current element is in the correct position
            while (j >= 0 && array[j + 1] < array[j]) {
                ArrayUtil.swap(array, j + 1, j);
                j--;
            }
        }
        System.out.print("Insertion sort using swapping: ");
        ArrayUtil.printArray(array);
    }


}
