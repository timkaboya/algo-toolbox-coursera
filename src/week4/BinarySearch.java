package week4;

import java.io.*;
import java.util.*;


/**
 * ===== Implement the Binary Search Algorithm
 * Input: first line has n, and a sequence of n +ve increasing integers.
 *        2nd line has integer k and k positive integers
 * Output: index of each element in line 2 after searching in line 1.
 * If value non existent, return -1.
 *
 */

public class BinarySearch {


    /**
     * Method returns the index of x in the array.
     * If not found, it returns -1.
     * @param a
     * @param x
     * @return
     */
    static int binarySearch(int[] a, int left, int right, int x) {
        int mid;
        // Bounds checking
        if((left >= right) && (a[left] != x))
            return -1;

        mid = left + (right - left) / 2;

        if( x == a[mid])
            return mid;
        else if (x < a[mid])
            return binarySearch(a, left, mid - 1, x);
        else if (x > a[mid])
            return binarySearch(a, mid + 1, right, x);

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            // System.out.print(linearSearch(a, b[i]) + " ");
            System.out.print(binarySearch(a, 0, a.length - 1, b[i]) + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
