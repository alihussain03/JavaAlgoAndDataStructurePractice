package com.practice.Array.old;

public class Array_4_RemoveDuplicates {
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
     * solve using Two pointers
     */
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize two pointers: one for the unique elements (slow), and one for iterating through the array (fast)
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            // If the current element is different from the last unique element, move the slow pointer and update the value
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        // The number of unique elements is slow pointer index + 1
        return slow + 1;
    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
     * solve using Two pointers
     */
    public int removeDuplicatesKeepAtMostTwo(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2;

        // Start fast pointer at index 2
        for (int fast = 2; fast < nums.length; fast++) {
            // Compare the current element with the element two positions before
            if (nums[fast] != nums[slow - 2]) {
                // If different, move the slow pointer and update the element
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Array_4_RemoveDuplicates solution = new Array_4_RemoveDuplicates();

        int[] nums = {0, 0, 1, 1, 2, 2, 3, 3, 4};
        int k = solution.removeDuplicates(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        nums = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4};
        k = solution.removeDuplicatesKeepAtMostTwo(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Number of unique elements: " + k);

        // Output the array up to the k elements
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
