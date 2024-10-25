package com.Sorting;

import com.util.ArrayUtil;

import java.util.ArrayList;

/* 0(nlogn) */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {13, 46, 24, 52, 20, 9};
        mergeSort(array, 0, array.length - 1);
        ArrayUtil.printArray(array);
    }

    /*
     * Time complexity: O(n²)
     * Space complexity: O(1)
     */
    static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        mergeArray(array, low, mid, high);
    }

    static void mergeArray(int[] array, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                list.add(array[left]);
                left++;
            } else {
                list.add(array[right]);
                right++;
            }
        }
        while (left <= mid) {
            list.add(array[left]);
            left++;
        }
        while (right <= high) {
            list.add(array[right]);
            right++;
        }
        for (int i = 0; i < list.size(); i++) {
            array[low + i] = list.get(i);
        }
    }

    static void mergeArray2(int[] array, int low, int mid, int high) {
        // Temporary array to store merged elements
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        // Merge elements from both halves into temp in sorted order
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp[k++] = array[left++];
            } else {
                temp[k++] = array[right++];
            }
        }

        // Copy any remaining elements from the left half
        while (left <= mid) {
            temp[k++] = array[left++];
        }

        // Copy any remaining elements from the right half
        while (right <= high) {
            temp[k++] = array[right++];
        }

        // Copy sorted elements back into the original array
        System.arraycopy(temp, 0, array, low, temp.length);
    }
}