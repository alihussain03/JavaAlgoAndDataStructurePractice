package com.practice.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

/* https://www.geeksforgeeks.org/print-subsequences-string/ */
public class RecursionBacktracking_7_AllSubSequences {
    static List<String> listOfALLSequences = new ArrayList<>();
    static ArrayList<Integer> listOfALLSequencesWithSumK = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abc";
        findSubSequences(s, "");
        System.out.println(listOfALLSequences);

        int[] data = new int[]{1, 2, 3};
        int k = 3;
        findSubSequencesWithSumK(data, 0, "");
        findSubSequencesWithSumK1(data, 0, listOfALLSequencesWithSumK, 3, 0);
    }

    static void findSubSequences(String currentString, String currentAnswer) {
        //  System.out.println("String: " + currentString + " && Current Answer: " + currentAnswer);
        if (currentString.isEmpty()) {
            //  System.out.println(currentAnswer);
            listOfALLSequences.add(currentAnswer);
            return;
        }

        //add adding 1st character in string
        findSubSequences(currentString.substring(1), currentAnswer + currentString.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findSubSequences(currentString.substring(1), currentAnswer);
    }

    static void findSubSequencesWithSumK(int[] numbers, int index, String k) {
        if (index == numbers.length) {
            System.out.println(k);
            return;
        }
        findSubSequencesWithSumK(numbers, index + 1, k + numbers[index] + " ");
        findSubSequencesWithSumK(numbers, index + 1, k);
    }

    static void findSubSequencesWithSumK1(int[] numbers, int index, ArrayList<Integer> output, int target, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                System.out.println(output);
            }

            return;
        }
        output.add(numbers[index]);
        sum += numbers[index];
        findSubSequencesWithSumK1(numbers, index + 1, output, target, sum);
        output.removeLast();
        sum -= numbers[index];
        findSubSequencesWithSumK1(numbers, index + 1, output, target, sum);
    }
}
