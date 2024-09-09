package com.practice.Array;

public class Array_8_isArraySorted {
    public static void main(String[] args) {
        System.out.println("Is Sorted: " + isSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    private static boolean isSorted(int[] arr) {

        // Edge case: an array with 0 or 1 element is always sorted
        if (arr == null || arr.length <= 1) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
