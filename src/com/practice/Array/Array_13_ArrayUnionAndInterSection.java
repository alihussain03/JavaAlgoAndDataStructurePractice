package com.practice.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Array_13_ArrayUnionAndInterSection {
    public static void main(String[] args) {
        System.out.println("Array Union");
        System.out.println(findUnionTwoPointer(new int[]{1, 2, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8}));
        System.out.println(findUnionUsingSet(new int[]{1, 2, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8}));
        System.out.println(Arrays.toString(findIntersection(new int[]{1, 2, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7, 8})));
    }

    static ArrayList<Integer> findUnionTwoPointer(int[] arr1, int[] arr2) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                union.add(arr1[i++]);
            } else if (arr1[i] > arr2[j]) {
                union.add(arr2[j++]);
            } else {
                union.add(arr1[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements
        while (i < arr1.length) {
            union.add(arr1[i++]);
        }

        while (j < arr2.length) {
            union.add(arr2[j++]);
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
