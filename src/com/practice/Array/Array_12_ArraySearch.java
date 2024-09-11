package com.practice.Array;

public class Array_12_ArraySearch {
    public static void main(String[] args) {
        int[] arr = {4, 0, 6, 7, 0, 1, 0, 6}; // Output: [4, 6, 7, 1, 6, 0, 0, 0]
        System.out.println(linearSearch(arr, 6));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

    private static int linearSearch(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i) {
                return j;
            }
        }
        return -1;
    }

    /**
     * TODO: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
     */
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if mid is even or odd and adjust accordingly
            if (mid % 2 == 1) {
                mid--; // Make mid even so we can check pairs
            }

            // If nums[mid] == nums[mid + 1], the single element is in the right half
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                // Otherwise, it's in the left half
                high = mid;
            }
        }

        // When low meets high, it points to the single element
        return nums[low];
    }
}
