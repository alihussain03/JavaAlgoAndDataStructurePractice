package com.practiceExamples.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/palindrome-partitioning/description/ */
public class RecursionBacktracking_5_PalindromePartition {

  public static void main(String[] args) {
    List<List<String>> res = partition("aab");
    res.forEach(System.out::println);
  }

  static List<List<String>> partition(String s) {

    List<List<String>> res = new ArrayList<List<String>>();
    List<String> cur = new ArrayList<String>();

    recur(s, 0, s.length(), cur, res);
    return res;

  }

  static void recur(String s, int ind, int n, List<String> cur, List<List<String>> res) {
    if (ind == n) {
      res.add(new ArrayList<>(cur));
      return;
    }

    for (int i = ind; i < n; i++) {
      //   System.out.println("Before :" + s.substring(ind, i + 1));
      if (isPalindrome(s, ind, i)) {
        //     System.out.println("After :" + s.substring(ind, i + 1));
        cur.add(s.substring(ind, i + 1));
        recur(s, i + 1, n, cur, res);
        //cur.remove(cur.size() - 1);
        cur.removeLast();
      }
    }
  }

  static boolean isPalindrome(String s, int ind1, int ind2) {
    while (ind1 < ind2) {
      if (s.charAt(ind1) != s.charAt(ind2)) {
        return false;
      }
      ind1++;
      ind2--;
    }

    return true;
  }
}
