package week2;

import java.awt.*;
import java.util.*;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long lcm(int a, int b) {
        return (long) (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        int a, b;
        /* Stress Testing  */
        /*
        Random rand = new Random();
        while (true) {
            a = rand.nextInt(20000) + 1;
            b = rand.nextInt(20000);
            if (lcm_naive(a, b) == lcm(a, b))
                System.out.println("OK! ");
            else {
                System.out.println("Wrong: " + a + ":" + b + "=>>" + lcm_naive(a, b) + " " + lcm(a, b));
                break;
            }
        }
        */

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
