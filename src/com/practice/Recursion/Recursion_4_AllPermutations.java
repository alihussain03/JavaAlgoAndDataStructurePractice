package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/permutations/description/ */
public class Recursion_4_AllPermutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = permute(arr);
        res.forEach(System.out::println);
        System.out.println(res.size());
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(nums, 0, res);
        return res;
    }

    static void solve(int[] nums, int index, List<List<Integer>> res) {
        int n = nums.length;
        if (index == n - 1) {
            List<Integer> subList = new ArrayList<Integer>();
            for (int data : nums) {
                subList.add(data);
            }
            res.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i < n; i++) {
            swap(nums, i, index);
            solve(nums, index + 1, res);
            swap(nums, i, index);
        }
    }

    static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
