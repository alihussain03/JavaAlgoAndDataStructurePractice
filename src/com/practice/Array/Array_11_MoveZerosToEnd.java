package com.practice.Array;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class Array_11_MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {4, 0, 6, 7, 0, 1, 0, 6}; // Output: [4, 6, 7, 1, 6, 0, 0, 0]
        moveZerosToEnd(arr);
        System.out.println();
        arr = new int[]{4, 0, 6, 7, 0, 1, 0, 6};
        moveZeroes(arr);
    }

    private static void moveZerosToEnd(int[] arr) {
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != 0) {
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
                slow++;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // TODO: need to check this
    public static void moveZeroes(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                moveIt(nums, i, c);
                break;
            }
        }
    }

    public static void moveIt(int[] nums, int i, int c) {
        c++;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
                moveIt(nums, j, c);
                return;
            }
            nums[j - c] = nums[j];
        }
        for (int k = 1; k < c + 1; k++) {
            nums[nums.length - k] = 0;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
