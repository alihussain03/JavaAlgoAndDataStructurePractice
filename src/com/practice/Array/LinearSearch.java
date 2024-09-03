package com.practice.Array;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 0, 6, 7, 0, 1, 0, 6}; // Output: [4, 6, 7, 1, 6, 0, 0, 0]
        System.out.println(linearSearch(arr, 6));
    }

    private static int linearSearch(int[] arr, int i) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            if (arr[first] == i) {
                System.out.println("Element found at index: " + first);
                return first;
            }
            if (arr[last] == i) {
                System.out.println("Element found at index: " + last);
                return last;
            }
            first++;
            last--;
        }
        return -1;
    }
}
