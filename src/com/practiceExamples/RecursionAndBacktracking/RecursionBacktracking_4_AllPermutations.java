package com.practiceExamples.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/permutations/description/
 * https://www.youtube.com/watch?v=m9HgMrsdvaQ&list=PLQ7ZAf76c0ZMzC9OHPbo-dUgx6oU3T0jK&index=14
 */
public class RecursionBacktracking_4_AllPermutations {

  public static void main(String[] args) {
    int[] nums = {1, 1, 2};
    List<List<Integer>> res = allPermutations(nums);
    res.forEach(System.out::println);
    System.out.println(res.size());

    System.out.println("Unique permutations:");
    res = new ArrayList<>();
    Arrays.sort(nums); // Sort the array to handle duplicates
    uniquePermutationsSolution(res, new ArrayList<>(), nums, new boolean[nums.length]);
    res.forEach(System.out::println);
    System.out.println(res.size());
  }

  static List<List<Integer>> allPermutations(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    allPermutationsSolution(nums, 0, res);
    return res;
  }

  static void allPermutationsSolution(int[] nums, int index, List<List<Integer>> res) {
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
      allPermutationsSolution(nums, index + 1, res);
      swap(nums, i, index);
    }
  }

  /* https://leetcode.com/problems/permutations-ii/ */
  static void uniquePermutationsSolution(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums,
      boolean[] used) {
    // If tempList size matches nums length, we have a full permutation
    if (tempList.size() == nums.length) {
      resultList.add(new ArrayList<>(tempList));  // Store the current permutation
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // Skip used elements or skip duplicates
      if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
        continue;
      }

      // Mark as used and add the current element to tempList
      used[i] = true;
      tempList.add(nums[i]);

      // Recursively generate the permutations
      uniquePermutationsSolution(resultList, tempList, nums, used);

      // Backtrack: undo the choice
      used[i] = false;
      tempList.remove(tempList.size() - 1);
    }
  }

  static void swap(int[] nums, int from, int to) {
    int temp = nums[from];
    nums[from] = nums[to];
    nums[to] = temp;
  }
}