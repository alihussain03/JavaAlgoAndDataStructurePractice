package AlgoMap.HashMapsAndSets;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/description/">LeetCode</a>
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
  }

  static boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Integer> mapST = new HashMap<>();
    for (int num : nums) {
      if (!mapST.containsKey(num)) {
        mapST.put(num, 1);
      } else {
        return true;
      }
    }
    return false;
  }
}