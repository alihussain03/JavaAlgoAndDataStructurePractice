package com.leetcode75;

public class LeetCode_01_MergeAlternately {

  public static void main(String[] args) {
    System.out.println(mergeAlternately("abcd", "pq")); //"apbqcd"
  }

  public static String mergeAlternately(String word1, String word2) {

    int minSize = Math.min(word1.length(), word2.length());
    StringBuilder buf = new StringBuilder();

    for (int i = 0; i < minSize; i++) {
      buf.append(word1.charAt(i));
      buf.append(word2.charAt(i));
    }

    if (word1.length() != word2.length()) {
      String maxString = word1.length() > word2.length() ? word1 : word2;
      buf.append(maxString.substring(minSize));
    }
    return buf.toString();
  }
}