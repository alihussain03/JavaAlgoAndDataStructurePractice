package com.practice.Array;

import java.util.Arrays;

/**
 * <a href="https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/">...</a>
 * <p>
 * Two Pointers Approach:
 */
public class Array_1_MaxMinOfArray {
    public static void main(String[] args) {
        System.out.println("Max and Min of Array");
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int[] result = findMaxMin(arr);
        System.out.println("Max: " + result[0] + " Min: " + result[1]);
        result = findMaxMin1(arr);
        System.out.println("Max: " + result[0] + " Min: " + result[1]);
        result = findMaxMinUsingLambda(arr);
        System.out.println("Max: " + result[0] + " Min: " + result[1]);
    }

    public static int[] findMaxMin(int[] arr) {
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        return getInts(arr, result, max, min);
    }

    public static int[] findMaxMin1(int[] arr) {
        int[] result = new int[2];
        int max = arr[0];
        int min = arr[0];

        return getInts(arr, result, max, min);
    }

    private static int[] getInts(int[] arr, int[] result, int max, int min) {
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        result[0] = max;
        result[1] = min;
        return result;
    }

    public static int[] findMaxMinUsingLambda(int[] arr) {
        int max = Arrays.stream(arr).max().orElseThrow();
        int min = Arrays.stream(arr).min().orElseThrow();

        return new int[]{max, min};
    }

}
