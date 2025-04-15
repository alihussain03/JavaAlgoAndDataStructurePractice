package AlgoMaster.Array;

import util.CollectionUtil;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] numArray = {0, 0, 1, 1, 2, 2, 3, 3, 4};
    int k = removeDuplicatesInPlaceAndReturnUniqueCount(numArray);
    System.out.println("Number of unique elements: " + k);
    System.out.println("Unique elements are: ");
    CollectionUtil.printArray(numArray);

    System.out.println("----------");
    int[] numArray2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    int k2 = removeDuplicatesKeepAtMostTwo(numArray2);
    System.out.println("Number of unique elements: " + k2);
    System.out.println("Unique elements at most twice: ");
    CollectionUtil.printArray(numArray2);
  }

  /**
   * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/ solve using Two pointers
   */
  static int removeDuplicatesInPlaceAndReturnUniqueCount(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int slow = 0;

    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow]) {
        slow++;
        nums[slow] = nums[fast];
      }
    }
    return slow + 1;
  }

  /**
   * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/ solve using Two pointers
   */
  static int removeDuplicatesKeepAtMostTwo(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int slow = 2;
    for (int fast = 2; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow - 2]) {
        nums[slow] = nums[fast];
        slow++;
      }
    }
    return slow;
  }
}
