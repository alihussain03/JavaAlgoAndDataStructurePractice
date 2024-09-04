package com.practice.Array;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 0, 6, 7, 0, 1, 0, 6}; // Output: [4, 6, 7, 1, 6, 0, 0, 0]
        System.out.println(linearSearch(arr, 6));
    }

    private static int linearSearch(int[] arr, int i) {
        int first = 0;
        int last = arr.length - 1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i) {
                return j;
            }
        }
        return -1;
    }
}
