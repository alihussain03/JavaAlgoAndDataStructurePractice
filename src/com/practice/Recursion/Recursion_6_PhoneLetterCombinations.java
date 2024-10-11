package com.practice.Recursion;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/ */
public class Recursion_6_PhoneLetterCombinations {
    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans.size());
        ans.forEach(System.out::println);
    }

    static List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> numSeq = new ArrayList<String>();
        if (digits.isEmpty()) {
            return numSeq;
        }
        recur(digits, 0, new StringBuilder(), numSeq, letters);
        return numSeq;
    }

    static void recur(String digits, int index, StringBuilder currentAnswer, List<String> numSeq, String[] letters) {
        if (index == digits.length()) {
            numSeq.add(String.valueOf(currentAnswer));
            return;
        }
        String curAlphabets = letters[digits.charAt(index) - '0'];
        for (char num : curAlphabets.toCharArray()) {
            currentAnswer.append(num);
            recur(digits, index + 1, currentAnswer, numSeq, letters);
            currentAnswer.deleteCharAt(currentAnswer.length() - 1);
        }
    }
}
