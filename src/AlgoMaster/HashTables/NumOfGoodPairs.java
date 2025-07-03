package AlgoMaster.HashTables;

import java.util.HashMap;
import java.util.Map;
import util.GeneralUtil;

/* https://leetcode.com/problems/number-of-good-pairs/description/ */
public class NumOfGoodPairs {

  public static void main(String[] args) {
    int[] numArray = {1, 2, 3, 1, 1, 3};
    System.out.println(numIdenticalPairs(numArray));
    GeneralUtil.newFunctionCall();
    System.out.println(numIdenticalPairsSpeedEfficient(numArray));
  }

  static int numIdenticalPairs(int[] nums) {
    Map<Integer, Integer> numberCount = new HashMap<>();
    for (int num : nums) {
      numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
    }

    int count = 0;
    for (int freq : numberCount.values()) {
      if (freq > 1) {
        count += freq * (freq - 1) / 2;  // nC2 = n*(n-1)/2
      }
    }
    return count;
  }

  static int numIdenticalPairsSpeedEfficient(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          count++;
        }
      }
    }
    return count;
  }
}