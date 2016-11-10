package week3;

import java.util.Scanner;


/*
 * Problem: Changing Money!
 * Explanation: Find the minimum number of coins needed to change the input value (an int)
 * into coins with denominations of 1, 5, and 10
 * Input: Single integer m
 * Output: Min number of coins with denominations 1, 5, 10 that changes m.
 *
 * Soln: Design a greedy algorithm for this one.
 */
public class Change {
    private static int getChange(int m) {
        //write your code here
        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

