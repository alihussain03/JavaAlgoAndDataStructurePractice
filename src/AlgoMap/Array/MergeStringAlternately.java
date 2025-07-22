package AlgoMap.Array;

import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/description/">LeetCode</a>
 */
public class MergeStringAlternately {

  public static void main(String[] args) {
    System.out.println(mergeAlternately("abc", "pqr"));
    GeneralUtil.newFunctionCall();
    System.out.println(mergeAlternately("cf", "eee"));

  }

  static String mergeAlternately(String word1, String word2) {
    char[] charArray1 = word1.toCharArray();
    char[] charArray2 = word2.toCharArray();
    StringBuilder result = new StringBuilder();
    int i = 0;
    while (i < charArray1.length && i < charArray2.length) {
      result.append(charArray1[i]).append(charArray2[i]);
      i++;
    }

    if (i < charArray1.length) {
      while (i < charArray1.length) {
        result.append(charArray1[i]);
        i++;
      }
    } else if (i < charArray2.length) {
      while (i < charArray2.length) {
        result.append(charArray2[i]);
        i++;
      }
    }
    return result.toString();
  }
}