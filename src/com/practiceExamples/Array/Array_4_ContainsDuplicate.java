package com.practiceExamples.Array;

import java.util.HashSet;

/* https://leetcode.com/problems/contains-duplicate/  */
public class Array_4_ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("Contains Duplicate");
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
    }

    private static boolean containsDuplicate(int[] arr) {
        HashSet<Integer> map = new HashSet<>();
        for (int i : arr) {
            if (map.contains(i)) {
                return true;
            }
            map.add(i);
        }
        return false;
    }

    // This is advance solution. will check it later.
    public static boolean containsDuplicate1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            } else if (nums[i] < nums[i - 1]) {
                int val = nums[i];
                for (int j = i - 2; j >= 0; j--) {
                    if (val == nums[j]) {
                        return true;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
        return false;
    }
}
