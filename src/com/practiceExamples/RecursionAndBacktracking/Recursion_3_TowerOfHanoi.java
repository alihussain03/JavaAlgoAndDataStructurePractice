package com.practiceExamples.RecursionAndBacktracking;

/* https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card */

public class Recursion_3_TowerOfHanoi {
    public static void main(String[] args) {
        int n = 2; // Number of disks
        long totalMoves = toh(n, 1, 3, 2); // Move from rod 1 to rod 3 using rod 2 as auxiliary
        System.out.println(totalMoves);
    }

    static long toh(int n, int from, int to, int aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return 1;
        }
        long moves = toh(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        moves++;
        moves += toh(n - 1, aux, to, from);
        return moves;
    }
}
