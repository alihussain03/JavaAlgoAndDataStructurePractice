package com.Sorting;

import com.util.CollectionUtil;

/* The algorithm "bubbles" the largest unsorted element to its correct position by
repeatedly comparing adjacent elements and swapping them if they are in the wrong order */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        bubbleSort(array);
        array = new int[]{1, 2, 3};
        bubbleSort2(array);

        System.out.println("\nBubble Sort using recursion");
        array = new int[]{13, 46, 24, 52, 20, 9};
        bubbleSortUsingRecursion(array, array.length - 1, 0);
        CollectionUtil.printArray(array);

        array = new int[]{13, 46, 24, 52, 20, 9};
        System.out.println("\nBubble Sort using optimized recursion");
        bubbleSortRecursiveWithOptimization(array, array.length);
        CollectionUtil.printArray(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     * Standard Bubble Sort implementation
     * */
    static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {

            for (int j = 0; j <= i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    CollectionUtil.swapArrayElements(array, j, j + 1);
                }
            }
        }
        System.out.println("Bubble sort: ");
        CollectionUtil.printArray(array);
    }

    // Optimized with a swapped flag to terminate early if the array is already sorted.
    static void bubbleSort2(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            boolean swapped = false; // Track if a swap was made in this pass

            // Inner loop to compare adjacent elements
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    CollectionUtil.swapArrayElements(array, j, j + 1);
                    swapped = true; // Mark that a swap has occurred
                }
            }

            // If no swaps were made, the array is already sorted
            if (!swapped) {
                break;
            }
        }

        System.out.println("\nBubble sort optimized: ");
        CollectionUtil.printArray(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     */
    static void bubbleSortUsingRecursion(int[] array, int i, int j) {
        if (i == 0) return;
        if (j < i) {
            if (array[j] > array[j + 1]) {
                CollectionUtil.swapArrayElements(array, j, j + 1);
            }
            bubbleSortUsingRecursion(array, i, j + 1);
        } else bubbleSortUsingRecursion(array, --i, 0);
    }

    static void bubbleSortRecursiveWithOptimization(int[] array, int n) {
        if (n == 1) return;
        boolean swapped = false;
        for (int i = 0; i <= n - 2; i++) {
            if (array[i] > array[i + 1]) {
                CollectionUtil.swapArrayElements(array, i, i + 1);
                swapped = true;
            }
        }
        if (!swapped) return;
        bubbleSortRecursiveWithOptimization(array, n - 1);
    }
}
