package com.practice.Array;

import java.util.ArrayList;

/* https://www.geeksforgeeks.org/program-to-reverse-an-array/ */
public class Array_2_ReverseArray {

    public static void main(String[] args) {
        System.out.println("Reverse an Array");
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverseArrayUsingTwoPointers(arr);
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
        reverseArrayUsingTwoPointers(arrList, 2, 4);
        System.out.println(arrList);
    }

    private static void reverseArrayUsingTwoPointers(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void reverseArrayUsingTwoPointers(ArrayList<Integer> arr, int left, int right) {
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
