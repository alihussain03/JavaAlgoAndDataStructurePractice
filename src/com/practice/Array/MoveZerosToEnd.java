package com.practice.Array;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {4, 0, 6, 7, 0, 1, 0, 6}; // Output: [4, 6, 7, 1, 6, 0, 0, 0]
        moveZerosToEnd(arr);
        System.out.println();
        arr = new int[]{4, 0, 6, 7, 0, 1, 0, 6};
        moveZerosToEnd2(arr);
    }

    private static void moveZerosToEnd(int[] arr) {
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != 0) {
                arr[slow] = arr[fast];
                slow++;
            }
        }
        for (int i = slow; i < arr.length; i++) {
            arr[i] = 0;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void moveZerosToEnd2(int[] arr) {

        int slow = 0;
        for (int i : arr) {
            if (i == 0) {
                slow = 1;
                break;
            }
        }
        for (int fast = slow + 1; fast < arr.length; fast++) {
            if (arr[fast] != 0) {
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
                slow++;
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
