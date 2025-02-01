package com.practiceExamples.Array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/majority-element/
 * Input: nums = [3,2,3]
 * Output: 3
 */
public class Array_21_MajorityElement_BoyerMooreVoting {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElementUsingHashMap(arr));
        System.out.println(majorityElement(arr));
    }

    public static int majorityElementUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
            if (map.get(j) > (arr.length / 2)) {
                return j;
            }
        }
        return -1;
    }

    public static int majorityElement(int[] arr) {
        int count = 0;
        int candidate = 0;

        //applying the algorithm:
        for (int j : arr) {
            if (count == 0) {
                count = 1;
                candidate = j;
            } else if (candidate == j) count++;
            else count--;
        }

        //checking if the stored element is the majority element:
        count = 0;
        for (int j : arr) {
            if (j == candidate) count++;
        }

        return (count > (arr.length / 2)) ? candidate : -1;
    }
}
