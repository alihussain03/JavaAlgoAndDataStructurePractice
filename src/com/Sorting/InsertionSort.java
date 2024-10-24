package com.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        insertionSort(array);
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
        printArray(array);
    }

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
