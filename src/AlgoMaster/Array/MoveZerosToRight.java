package AlgoMaster.Array;

import util.CollectionUtil;

/* https://leetcode.com/problems/move-zeroes/ */
public class MoveZerosToRight {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int n = nums.length;
        int nonZeroIndex = 0;

        // Move non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                CollectionUtil.swapArrayElements(nums, i, nonZeroIndex);
                nonZeroIndex++;
            }
        }
        CollectionUtil.printArray(nums);
    }
}


