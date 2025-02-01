package com.practiceExamples.Array;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class Array_15_FindMissingNumber {
    public static void main(String[] args) {
        System.out.println("Find Missing Number");
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10}));
        System.out.println(findMissingNumber1(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10}));
        System.out.println(findMissingNumberXOR(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10}));
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;  // Array length plus 1 for the missing number
        int sum = (n * (n + 1)) / 2;  // Sum of first n natural numbers (n+1 elements)
        int total = 0;
        for (int j : arr) {  // Iterate through the entire array
            total += j;
        }
        return sum - total;  // The missing number
    }

    public static int findMissingNumber1(int[] arr) {
        int n = arr.length;
        int total = (n + 1) * (n + 2) / 2;  // Sum of all numbers including the missing one
        for (int num : arr) {
            total -= num;  // Subtract each number in the array from the total
        }
        return total;  // The result is the missing number
    }

    public static int findMissingNumberXOR(int[] arr) {
        int n = arr.length + 1;  // Since one number is missing
        int xorArray = 0;
        int xorFull = 0;

        // XOR all elements in the array
        for (int num : arr) {
            xorArray ^= num;
        }

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorFull ^= i;
        }

        // XOR of xorArray and xorFull will give the missing number
        return xorArray ^ xorFull;
    }

}
