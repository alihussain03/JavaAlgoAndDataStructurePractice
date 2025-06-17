package AlgoMaster.Array;

import util.CollectionUtil;

/* https://leetcode.com/problems/rotate-array/description/ */
public class RotateArray {

  public static void main(String[] args) {
    System.out.println("Brute Force:");
    bruteForce(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    System.out.println("----------------------");

    System.out.println("Rotate Array using additional memory:");
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotateArray(nums, k);
    for (int num : nums) {
      System.out.print(num + " "); // Output: 5 6 7 1 2 3 4
    }

    System.out.println("\n----------------------");
    System.out.println("Rotate With Out Extra Space:");
    nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    rotateWithOutExtraSpace(nums, k);
    for (int num : nums) {
      System.out.print(num + " "); // Output: 5 6 7 1 2 3 4
    }
  }

  static void bruteForce(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
      int temp = nums[nums.length - 1];
      for (int j = nums.length - 1; j > 0; j--) {
        nums[j] = nums[j - 1];
      }
      nums[0] = temp;
    }
    CollectionUtil.printArray(nums);

  }

  public static void rotateWithOutExtraSpace(int[] nums, int k) {
    int n = nums.length;
    k = k % n;  // Normalize k

    // Step 1: Reverse the entire array
    reverse(nums, 0, n - 1);

    // Step 2: Reverse the first k elements
    reverse(nums, 0, k - 1);

    // Step 3: Reverse the remaining n-k elements
    reverse(nums, k, n - 1);
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  private static void rotateArray(int[] nums, int k) {
    int n = nums.length;
    int[] rotated = new int[n];

    if (k >= 0) {
      System.arraycopy(nums, n - k + 0, rotated, 0, k);
    }

    if (n - k >= 0) {
      System.arraycopy(nums, k - k, rotated, k, n - k);
    }
    System.arraycopy(rotated, 0, nums, 0, n);
  }
}