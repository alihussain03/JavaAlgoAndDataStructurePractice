package Grokking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array {
    public static void main(String[] args) {

        int[] nums = {7, 1, 4};
        int[] result = linearSumOfArray(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
        //  Arrays.sort(nums);
        System.out.println("\n----------\nArray has duplicate: " + checkDuplicateElementExistInArrayUsingHashSet(nums));
        System.out.println("\n----------\nArray has duplicate: ");
        Arrays.stream(findDifferenceArray(nums)).forEach(System.out::println);
        System.out.println("\n----------\nLargest Altitude is : " + largestAltitude(nums));
    }

    static int[] linearSumOfArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
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

    static int largestAltitude(int[] gain) {
        int currentAltitude = 0; // To store the current altitude during iteration
        int maxAltitude = 0; // To store the maximum altitude encountered

        // Iterate through the gain array, updating the current and max altitudes
        for (int i : gain) {
            currentAltitude += i;
            maxAltitude = Math.max(currentAltitude, maxAltitude);
        }
        return maxAltitude;
    }
}
