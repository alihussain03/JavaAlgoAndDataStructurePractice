package com.practice.RecursionAndBacktracking;

import java.util.ArrayList;

/* https://www.geeksforgeeks.org/find-all-subsequences-with-sum-equals-to-k/ */
public class RecursionBacktracking_9_AllSubSequencesWithSumK {
    public static void main(String[] args) {
        ArrayList<Integer> listOfALLSequencesWithSumK = new ArrayList<>();
        int[] data = new int[]{1, 2, 3};
        int k = 11;
        findSubSequencesWithSumK(data, 0, listOfALLSequencesWithSumK, 3, 0);
        listOfALLSequencesWithSumK.forEach(System.out::println);
    }

    static void findSubSequencesWithSumK(int[] numbers, int index, ArrayList<Integer> output, int target, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                System.out.println(output);
            }

            return;
        }
        output.add(numbers[index]);
        sum += numbers[index];
        findSubSequencesWithSumK(numbers, index + 1, output, target, sum);
        output.removeLast();
        sum -= numbers[index];
        findSubSequencesWithSumK(numbers, index + 1, output, target, sum);
    }
}
