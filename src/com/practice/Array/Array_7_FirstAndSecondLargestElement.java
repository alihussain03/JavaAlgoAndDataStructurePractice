package com.practice.Array;

public class Array_7_FirstAndSecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 7, 6};
        System.out.println("First Largest: " + firstLargest(arr));
        System.out.println("Second Largest: " + secondLargest(arr));
    }

    private static int firstLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax && arr[i] != firstMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}
