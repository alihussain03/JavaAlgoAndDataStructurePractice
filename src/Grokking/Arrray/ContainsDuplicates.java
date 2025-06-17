package Grokking.Arrray;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

  public static void main(String[] args) {
    int[] nums = {7, 1, 4};
    System.out.println("----------\nArray has duplicate: " + checkDuplicateElementExistInArrayUsingHashSet(nums));
  }

  static boolean checkDuplicateElementExistInArrayUsingHashSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }
}