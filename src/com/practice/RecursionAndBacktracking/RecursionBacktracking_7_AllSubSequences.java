package com.practice.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;


public class RecursionBacktracking_7_AllSubSequences {
    static List<String> listOfALLSequences = new ArrayList<>();


    public static void main(String[] args) {
        String s = "abc";
        findSubSequencesForString(s, "");
        System.out.println(listOfALLSequences);

        int[] data = new int[]{1, 2, 3};
        findSubSequencesForIntegers(data, 0, "");

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findSubSequencesForIntegers2(data, 0, res, temp);
    }

    /* https://www.geeksforgeeks.org/print-subsequences-string/ */
    static void findSubSequencesForString(String currentString, String currentAnswer) {
        //  System.out.println("String: " + currentString + " && Current Answer: " + currentAnswer);
        if (currentString.isEmpty()) {
            //  System.out.println(currentAnswer);
            listOfALLSequences.add(currentAnswer);
            return;
        }

        //add adding 1st character in string
        findSubSequencesForString(currentString.substring(1), currentAnswer + currentString.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findSubSequencesForString(currentString.substring(1), currentAnswer);
    }

    static void findSubSequencesForIntegers(int[] numbers, int index, String k) {
        if (index == numbers.length) {
            System.out.println(k);
            return;
        }
        findSubSequencesForIntegers(numbers, index + 1, k + numbers[index] + " ");
        findSubSequencesForIntegers(numbers, index + 1, k);
    }

    static void findSubSequencesForIntegers2(int[] arr, int index, List<List<Integer>> res, List<Integer> temp) {
        if (index == arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[index]);
        findSubSequencesForIntegers2(arr, index + 1, res, temp);
        temp.removeLast();
        findSubSequencesForIntegers2(arr, index + 1, res, temp);
    }

}
