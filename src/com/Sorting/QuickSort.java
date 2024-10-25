package com.Sorting;

import com.util.ArrayUtil;

// PPartitioning
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, 6, 8, 10, 1, 2, 1};
        quickSort(array, 0, array.length - 1);
        ArrayUtil.printArray(array);
    }


    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = findPivot(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    static int findPivot(int[] array, int low, int high) {
        int j = high, i = low + 1;
        int pivot = array[low];
        while (i <= j) { // Change this condition to avoid out-of-bounds
            while (i <= high && array[i] <= pivot) { // Ensure i does not exceed high
                i++;
            }
            while (j >= low && array[j] > pivot) { // Ensure j does not go below low
                j--;
            }
            if (i < j) {
                ArrayUtil.swap(array, i, j); // Correct swap between elements
            }
        }
        ArrayUtil.swap(array, low, j);

        return j;
    }
}
