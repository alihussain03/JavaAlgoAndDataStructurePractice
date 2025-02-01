package com.practiceExamples.Array;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated Sorted Array</a>
 */
public class Array_6_SearchInSortedArray {
    public static void main(String[] args) {
        System.out.println("Contains Duplicate");
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchRotated(arr, 0));
    }

    public static int searchRotated(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part of the array is sorted
            if (nums[left] <= nums[mid]) {
                // Left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is in the left part
                    right = mid - 1;
                } else {
                    // Target is in the right part
                    left = mid + 1;
                }
            } else {
                // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is in the right part
                    left = mid + 1;
                } else {
                    // Target is in the left part
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


}
