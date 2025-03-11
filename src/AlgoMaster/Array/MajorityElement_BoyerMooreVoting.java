package AlgoMaster.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement_BoyerMooreVoting {
    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 0};
        System.out.println("Majority Element is : " + majorityElement(nums));
        System.out.println("Majority Element using second solution is : " + majorityElement2(nums));
        System.out.println("Majority Element using HashMap is : " + majorityElement3(nums));
        System.out.println("Majority Element using third solution is : " + twoMajorityElement(nums));
    }

    /* https://leetcode.com/problems/majority-element/description/ */
    public static int majorityElement(int[] arr) {
        int count = 0;
        int candidate = 0;

        //step1: applying Boyer Moore Voting algorithm:
        for (int j : arr) {
            if (count == 0) {
                count = 1;
                candidate = j;
            } else if (candidate == j) count++;
            else count--;
        }

        //step2: verify if the stored element is the majority element:
        count = 0;
        for (int j : arr) {
            if (j == candidate) count++;
        }

        return (count > (arr.length / 2)) ? candidate : -1;
    }

    public static int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static int majorityElement3(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
            if (map.get(j) > (arr.length / 2)) {
                return j;
            }
        }
        return -1;
    }

    /* https://leetcode.com/problems/majority-element-ii/description/ */
    public static List<Integer> twoMajorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            if (num == candidate2) count2++;
        }
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }


}
