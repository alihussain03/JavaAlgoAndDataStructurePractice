package AlgoMaster.BitManipulation;

public class SingleNumber {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 2, 3, 2};
    // System.out.println(singleNumber(arr));
    System.out.println(singleNumber2(arr));
  }

  /* https://leetcode.com/problems/single-number/description/ */
  static int singleNumber(int[] nums) {
    int xor = 0;
    for (int num : nums) {
      xor = xor ^ num;
    }
    return xor;
  }

  /* https://leetcode.com/problems/single-number-ii/description/ */
  static int singleNumber2(int[] nums) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      int bitSum = 0;
      int bitMask = 1 << i;

      for (int num : nums) {
        if ((num & bitMask) != 0) {
          bitSum++;
        }
      }
      if (bitSum % 3 != 0) {
        result |= bitMask;
      }
    }
    return result;
  }

  /* https://leetcode.com/problems/single-number-iii/description/ */
  static int[] singleNumber3(int[] nums) {
    // Step 1: XOR of all numbers
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }

    // Step 2: Find a set bit (rightmost set bit)
    int rightmostSetBit = xor & (-xor);

    // Step 3: Divide numbers into two groups and XOR separately
    int num1 = 0, num2 = 0;
    for (int num : nums) {
      if ((num & rightmostSetBit) == 0) {
        num1 ^= num;
      } else {
        num2 ^= num;
      }
    }

    return new int[]{num1, num2};
  }
}