package Grokking.Arrray;

import com.util.CollectionUtil;

public class DifferenceArray {
    public static void main(String[] args) {
        int[] nums = {7, 1, 4};
        //    System.out.println("----------\nArray has duplicate: ");
        CollectionUtil.printArray(findDifferenceArray(nums));

    }

    static int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int leftSum = 0, rightSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        // Calculate the difference between left and right sums for each position
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            differenceArray[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }
        return differenceArray;
    }

    // Calculate the difference between left and right sums for each position in the array
    static int[] findDifferenceArray2(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            left = 0;
            right = 0;
            //left sum
            if (i == 0) {
                left = 0;
            } else for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            //right sum
            if (i == n - 1) {
                right = 0;
            } else for (int k = i + 1; k < n; k++) {
                right += nums[k];
            }
            //final output
            differenceArray[i] = Math.abs(right - left);
        }
        return differenceArray;
    }


}
