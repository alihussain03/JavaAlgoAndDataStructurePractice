package AlgoMaster.Array;

/* https://leetcode.com/problems/number-of-zero-filled-subarrays/description/ */
public class NoOfZerosInArray {

  public static void main(String[] args) {
    System.out.println(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    System.out.println(zeroFilledSubarray1(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
  }

  static long zeroFilledSubarray(int[] nums) {
    int numOfZeors = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int consectiveZero = 0;
        int j = i;
        while (j < nums.length && nums[j] == 0) {
          consectiveZero++;
          j++;
        }
        i = j;
        numOfZeors += (consectiveZero * (consectiveZero + 1)) / 2;
      }
    }
    return numOfZeors;
  }

  static long zeroFilledSubarray1(int[] nums) {
    long count = 0;
    long consecutiveZeros = 0;
    for (int num : nums) {
      if (num == 0) {
        consecutiveZeros++;            // Extend the current zero sequence
        count += consecutiveZeros;     // Add all new zero subarrays ending here
      } else {
        consecutiveZeros = 0;          // Reset on non-zero
      }
    }
    return count;
  }
}