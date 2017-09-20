package week3;

import java.util.Scanner;


/*
 * Problem 1: Changing Money!
 * Explanation: Find the minimum number of coins needed to change the input value (an int)
 * into coins with denominations of 1, 5, and 10
 * Input: Single integer m
 * Output: Min number of coins with denominations 1, 5, 10 that changes m.
 *
 * Soln: Design a greedy algorithm for this one.
 */



/*
 * Divide by highest denomination and progressively go lower till one
 */
public class Change {
    private static int getChange(int m) {
        int ten = 10, five = 5, one = 1;
        int coins;

        coins = m/ten;
        m = m%ten;
        coins += m/five;
        m = m%five;
        coins += m/one;
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

