package com.practice.Array.old;

/**
 * https://leetcode.com/problems/rotate-array/description
 */
public class Array_1_RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArray(nums, k);
        for (int num : nums) {
            System.out.print(num + " "); // Output: 5 6 7 1 2 3 4
        }
        rotateWithOutExtraSpace(nums, k);
        for (int num : nums) {
            System.out.print(num + " "); // Output: 5 6 7 1 2 3 4
        }
    }

    /* Sliding window */
    private static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];

        for (int i = 0; i < k; i++) {
            rotated[i] = nums[n - k + i];
        }

        for (int i = k; i < n; i++) {
            rotated[i] = nums[i - k];
        }
        System.arraycopy(rotated, 0, nums, 0, n);

    }

    /* Approach for rotating an array in-place without using extra space */
    public static void rotateWithOutExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Normalize k

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
