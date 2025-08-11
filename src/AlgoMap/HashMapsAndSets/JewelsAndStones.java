package AlgoMap.HashMapsAndSets;

import java.util.HashSet;
import java.util.Set;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/jewels-and-stones/description/">LeetCode</a>
 */
public class JewelsAndStones {

  public static void main(String[] args) {
    System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    GeneralUtil.newFunctionCall();
    System.out.println(numJewelsInStones("z", "ZZ"));
    GeneralUtil.newFunctionCall();
  }

  static int numJewelsInStones(String jewels, String stones) {
    Set<Character> jewelsSet = new HashSet<>();
    for (char c : jewels.toCharArray()) {
      jewelsSet.add(c);
    }
    int sum = 0;
    for (char c : stones.toCharArray()) {
      if (jewelsSet.contains(c)) {
        sum++;
      }
    }
    return sum;
  }
}