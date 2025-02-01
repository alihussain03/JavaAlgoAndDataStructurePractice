package com.practiceExamples.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-array-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */
public class Array_13_ArrayUnion {
    public static void main(String[] args) {
        System.out.println("Array Union");
        System.out.println(findUnionTwoPointer(new int[]{1, 2, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8}));
        System.out.println(findUnionUsingTwoPointerEasy(new int[]{1, 2, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8}, 6, 6));
        System.out.println(findUnionUsingSet(new int[]{1, 2, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8}));
        System.out.println(Arrays.toString(findIntersection(new int[]{1, 2, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8})));
    }

    static ArrayList<Integer> findUnionTwoPointer(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstArray.length && j < secondArray.length) {
            // Skip duplicates in the firstArray
            while (i > 0 && i < firstArray.length && firstArray[i] == firstArray[i - 1]) {
                i++;
            }
            // Skip duplicates in the secondArray
            while (j > 0 && j < secondArray.length && secondArray[j] == secondArray[j - 1]) {
                j++;
            }
            if (i >= firstArray.length || j >= secondArray.length) {
                break;
            }
            if (firstArray[i] < secondArray[j]) {
                union.add(firstArray[i++]);
            } else if (firstArray[i] > secondArray[j]) {
                union.add(secondArray[j++]);
            } else {
                union.add(firstArray[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements
        while (i < firstArray.length) {
            union.add(firstArray[i++]);
        }

        while (j < secondArray.length) {
            union.add(secondArray[j++]);
        }

        return union;
    }

    public static ArrayList<Integer> findUnionUsingTwoPointerEasy(int arr1[], int arr2[], int n, int m) {
        // add your code here
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }


        while (i < n) {
            if (union.get(union.size() - 1) != arr1[i]) union.add(arr1[i]);
            i++;
        }

        while (j < m) {
            if (union.get(union.size() - 1) != arr2[j]) union.add(arr2[j]);
            j++;
        }

        return union;
    }


    static ArrayList<Integer> findUnionUsingSet(int[] arr1, int[] arr2) {
        HashSet<Integer> freq = new HashSet<>();
        for (int j : arr1) freq.add(j);
        for (int j : arr2) freq.add(j);

        return new ArrayList<>(freq);
    }

    public static int[] findIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> intersection = new ArrayList<>();

        // Step 1: Populate the frequency map with elements from arr1
        for (int num : arr1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find intersections with elements from arr2
        for (int num : arr2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0 && !intersection.contains(num)) {
                intersection.add(num);
                // Decrease the frequency of the current number
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }
        return intersection.stream().mapToInt(i -> i).toArray();
    }

}
