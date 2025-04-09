package AlgoMaster.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement_BoyerMooreVoting {
    public static void main(String[] args) {
        int[] numArray = new int[]{0, 0, 0};
        System.out.println("Majority Element is : " + majorityElement(numArray));
        System.out.println("Majority Element using second solution is : " + majorityElement2(numArray));
        System.out.println("Majority Element using HashMap is : " + majorityElement3(numArray));
        System.out.println("Majority Element using third solution is : " + twoMajorityElement(numArray));
    }

    /* https://leetcode.com/problems/majority-element/description/ */
    public static int majorityElement(int[] numArray) {
        int count = 0;
        int candidate = 0;

        //step1: applying Boyer Moore Voting algorithm:
        for (int num : numArray) {
            if (count == 0) {
                count = 1;
                candidate = num;
            } else if (candidate == num) count++;
            else count--;
        }

        //step2: verify if the stored element is the majority element:
        count = 0;
        for (int j : numArray) {
            if (j == candidate) count++;
        }

        return (count > (numArray.length / 2)) ? candidate : -1;
    }

    public static int majorityElement2(int[] numArray) {
        int count = 0;
        int candidate = 0;
        for (int num : numArray) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static int majorityElement3(int[] numArray) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : numArray) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > (numArray.length / 2)) {
                return num;
            }
        }
        return -1;
    }

    /* https://leetcode.com/problems/majority-element-ii/description/ */
    public static List<Integer> twoMajorityElement(int[] numArray) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;

        for (int num : numArray) {
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
        for (int num : numArray) {
            if (num == candidate1) count1++;
            if (num == candidate2) count2++;
        }
        if (count1 > numArray.length / 3) result.add(candidate1);
        if (count2 > numArray.length / 3) result.add(candidate2);
        return result;
    }


}
