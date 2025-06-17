package com.practiceExamples.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class RecursionBacktracking_8_AllSubSequencesWithSumK {

  public static void main(String[] args) {
    int target = 3;
    int[] data = new int[]{10, 1, 2, 7, 6, 1, 5};

    System.out.println("List of combination whose sum equals to K: ");
    List<List<Integer>> res = combinationSum(data, 11);
    res.forEach(System.out::println);

    ArrayList<Integer> listOfALLSequences = new ArrayList<>();
    data = new int[]{10, 1, 2, 7, 6, 1, 5};
    findSubSequencesWithSumKAndPrint(data, 0, listOfALLSequences, target, 0);
    listOfALLSequences.forEach(System.out::println);


  }

  static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    ArrayList<Integer> cur = new ArrayList<Integer>();
    listOfALLSequencesWithSumK(candidates, target, 0, cur, res);

    return res;
  }

  /* https://leetcode.com/problems/combination-sum/ */
  static void listOfALLSequencesWithSumK(int[] candidates, int target, int index, ArrayList<Integer> current,
      List<List<Integer>> result) {
    if (index == candidates.length) {
      if (target == 0) {
        result.add(new ArrayList<>(current));
      }
      return;
    }

    // pick
    if (candidates[index] <= target) {
      current.add(candidates[index]);
      listOfALLSequencesWithSumK(candidates, target - candidates[index], index, current, result);
      //  current.remove(current.size() - 1);
      current.removeLast();
    }

    // no pick
    listOfALLSequencesWithSumK(candidates, target, index + 1, current, result);
  }


  /* https://www.geeksforgeeks.org/find-all-subsequences-with-sum-equals-to-k/ */
  static void findSubSequencesWithSumKAndPrint(int[] numbers, int index, ArrayList<Integer> output, int target,
      int sum) {
    if (index == numbers.length) {
      if (sum == target) {
        System.out.println(output);
      }

      return;
    }
    output.add(numbers[index]);
    sum += numbers[index];
    findSubSequencesWithSumKAndPrint(numbers, index + 1, output, target, sum);
    output.removeLast();
    sum -= numbers[index];
    findSubSequencesWithSumKAndPrint(numbers, index + 1, output, target, sum);
  }
}