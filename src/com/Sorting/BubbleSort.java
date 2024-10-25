package com.Sorting;

import com.util.ArrayUtil;

/* The algorithm "bubbles" the largest unsorted element to its correct position by
repeatedly comparing adjacent elements and swapping them if they are in the wrong order */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        bubbleSort(array);
        array = new int[]{1, 2, 3};
        bubbleSort2(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     */
    static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {

            for (int j = 0; j <= i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtil.swap(array, j, j + 1);
                }
            }
        }
        System.out.print("Bubble sort: ");
        ArrayUtil.printArray(array);
    }

    static void bubbleSort2(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            boolean swapped = false; // Track if a swap was made in this pass

            // Inner loop to compare adjacent elements
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtil.swap(array, j, j + 1);
                    swapped = true; // Mark that a swap has occurred
                }
            }

            // If no swaps were made, the array is already sorted
            if (!swapped) {
                System.out.println("Not Swapped: " + array[i]);
                break;
            }
        }

        System.out.print("Bubble sort: ");
        ArrayUtil.printArray(array);
    }
}
