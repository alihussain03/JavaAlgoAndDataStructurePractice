package com.practice.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/combination-sum/ */
public class RecursionBacktracking_8_CombinationSum {

    public static void main(String[] args) {
        int target = 7;
        int[] data = new int[]{2, 3, 6, 7};
        List<List<Integer>> res = combinationSum(data, target);
        res.forEach(System.out::println);

    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        recur(candidates, target, 0, cur, res);
        return res;
    }

    static void recur(int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> result) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // pick
        if (candidates[index] <= target) {
            current.add(candidates[index]);
            recur(candidates, target - candidates[index], index, current, result);
            //  current.remove(current.size() - 1);
            current.removeLast();
        }

        // no pick
        recur(candidates, target, index + 1, current, result);
    }

}
