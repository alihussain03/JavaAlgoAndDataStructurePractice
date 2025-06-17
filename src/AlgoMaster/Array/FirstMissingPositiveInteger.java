package AlgoMaster.Array;

/* https://leetcode.com/problems/first-missing-positive/description/ */
public class FirstMissingPositiveInteger {

  public static void main(String[] args) {
    System.out.println(firstMissingPositive1(new int[]{1, 2, 9, 4, 5}));
  }

  public static int firstMissingPositive1(int[] nums) {
    int n = nums.length;

    // Step 1: Clean invalid numbers
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
      }
    }

    // Step 2: Use index as hash marker
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num <= n) {
        nums[num - 1] = -Math.abs(nums[num - 1]);
      }
    }

    // Step 3: Find first missing positive
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }

    // All numbers from 1 to n are present
    return n + 1;
  }
}