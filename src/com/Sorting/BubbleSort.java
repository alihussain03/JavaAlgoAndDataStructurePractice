package com.Sorting;

import util.CollectionUtil;

/* Bubble Sort repeatedly compares adjacent elements and swaps them if they are out of order,
   causing the largest unsorted element to 'bubble' to the correct position at the end of the array */
public class BubbleSort {

  public static void main(String[] args) {
    int[] array = {8, 1, 2, 6, 5};
    bubbleSort(array);
    array = new int[]{1, 2, 6, 5};
    bubbleSortOptimized(array);

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
   */
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
  static void bubbleSortOptimized(int[] array) {
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
    if (i == 0) {
      return;
    }
    if (j < i) {
      if (array[j] > array[j + 1]) {
        CollectionUtil.swapArrayElements(array, j, j + 1);
      }
      bubbleSortUsingRecursion(array, i, j + 1);
    } else {
      bubbleSortUsingRecursion(array, --i, 0);
    }
  }

  static void bubbleSortRecursiveWithOptimization(int[] array, int arrayLength) {
    if (arrayLength == 1) {
      return;
    }
    boolean swapped = false;
    for (int i = 0; i <= arrayLength - 2; i++) {
      if (array[i] > array[i + 1]) {
        CollectionUtil.swapArrayElements(array, i, i + 1);
        swapped = true;
      }
    }
    if (!swapped) {
      return;
    }
    bubbleSortRecursiveWithOptimization(array, arrayLength - 1);
  }
}