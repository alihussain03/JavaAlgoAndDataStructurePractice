package com.practice.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionBacktracking_8_AllSubSequencesWithSumK2 {

    public static void main(String[] args) {
        int target = 8;
        int[] data = new int[]{10, 1, 2, 7, 6, 1, 5};

        System.out.println("List of combination whose sum equals to K: ");
        List<List<Integer>> res = combinationSum(data, target);
        res.forEach(System.out::println);


    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);
        listOfALLSequencesWithSumK2(candidates, target, 0, cur, res);
        return res;
    }

    static void listOfALLSequencesWithSumK2(int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if ((i == index || candidates[i] != candidates[i - 1]) && candidates[index] <= target) {
                current.add(candidates[i]);
                listOfALLSequencesWithSumK2(candidates, target - candidates[i], i + 1, current, result);
                current.removeLast();
            }
        }
    }
}
