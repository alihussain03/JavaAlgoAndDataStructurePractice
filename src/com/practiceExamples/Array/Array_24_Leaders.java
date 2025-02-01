package com.practiceExamples.Array;

import java.util.ArrayList;
import java.util.Collections;

public class Array_24_Leaders {
    public static void main(String[] args) {
        System.out.println(printLeaders(new int[]{4, 7, 1, 0}));
    }

    static ArrayList<Integer> printLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                leaders.add(max);
                // Print the leader
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
