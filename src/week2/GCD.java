package week2;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class GCD {
    private static int gcd_naive(int a, int b) {
        if (b == 0) return a;
        int current_gcd = 1;
        for(int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static int gcd_euclidean(int a, int b) {
        if (b == 0) return a;
        return gcd_euclidean(b, a % b);
    }

    public static void main(String args[]) {
        int a, b;
        /* Stress Testing
        Random rand = new Random();
        while (true) {
            a = rand.nextInt(20000) + 1;
            b = rand.nextInt(20000);
            if (gcd_naive(a, b) == gcd_euclidean(a, b))
                System.out.println("OK! ");
            else {
                System.out.println("Wrong: " + a + ":" + b + "=>>" + gcd_naive(a, b) + " " + gcd_euclidean(a, b));
                break;
            }
        }

        */


        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
    }
}
