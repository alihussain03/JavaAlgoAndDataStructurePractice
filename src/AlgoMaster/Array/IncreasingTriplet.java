package AlgoMaster.Array;

/* https://leetcode.com/problems/increasing-triplet-subsequence/description/ */
public class IncreasingTriplet {

  public static void main(String[] args) {
    System.out.println(zeroFilledSubarray(new int[]{1,2,3,4,5}));
  }

  static boolean zeroFilledSubarray(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int num : nums) {
      if (num <= first) {
        first = num;          // update smallest so far
      } else if (num <= second) {
        second = num;         // update second smallest
      } else {
        // Found a number greater than both first and second
        return true;
      }
    }
    return false;
  }
}
