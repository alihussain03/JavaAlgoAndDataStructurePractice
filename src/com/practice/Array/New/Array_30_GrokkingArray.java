package com.practice.Array.New;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array_30_GrokkingArray {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] result = linearSumOfArray(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
        Arrays.sort(nums);
        System.out.println("\n----------\nArray has duplicate: " + checkDuplicateElementExistInArray(nums));
        System.out.println("\n----------\nArray has duplicate: " + checkDuplicateElementExistInArrayUsingHashSet(nums));
        result = findDifferenceArray(nums);
        System.out.println("\n----------\nArray has duplicate: " + findDifferenceArray(nums));
    }

    static int[] linearSumOfArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    static boolean checkDuplicateElementExistInArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkDuplicateElementExistInArrayUsingHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    static int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            left = 0;
            right = 0;
            //left sum
            if (i == 0) {
                left = 0;
            } else for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            //right sum
            if (i == n - 1) {
                right = 0;
            } else for (int k = i + 1; k < n; k++) {
                right += nums[k];
            }
            //final outout
            differenceArray[i] = Math.abs(right - left);
        }
        return differenceArray;
    }
}
