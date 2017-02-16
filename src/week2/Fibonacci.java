package week2;

import java.util.Random;
import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }
    private static long calc_fibsmart(int n) {
        long [] fibs = new long[n + 1];
        if (n < 2)
            return n;

        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i < n+1; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }
        return fibs[n];
    }

    public static void main(String args[]) {
        Random rand = new Random();
        int n;
        /* Stress Testing
        long res1, res2;
        while(true) {
            n = rand.nextInt(45);
            System.out.println("Fib for " + n);

            res1 = calc_fib(n);
            res2 = calc_fibsmart(n);
            if(res1 == res2)
                System.out.println("OK.");
            else {
                System.out.println("Wrong answer! res1: " + res1 + " res2: " + res2);
                break;
            }
        }
        */

        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        System.out.println(calc_fibsmart(n));
    }
}
