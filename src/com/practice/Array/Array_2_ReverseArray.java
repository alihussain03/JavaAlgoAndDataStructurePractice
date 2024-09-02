package com.practice.Array;

import java.util.ArrayList;

/**
 * <a href="https://www.geeksforgeeks.org/program-to-reverse-an-array/">Reverse an Array</a>
 *
 * Two Pointers Approach:
 */
public class Array_2_ReverseArray {
    public static void main(String[] args) {
        System.out.println("Reverse an Array");
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverseArray(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);
        arrList.add(6);
        arrList.add(7);
        reverseArray(arrList, 2, 4);
        System.out.println(arrList);
    }

    private static void reverseArray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void reverseArray(ArrayList<Integer> arr, int left, int right) {
        left = left - 1;
        right = right - 1;
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }
}
