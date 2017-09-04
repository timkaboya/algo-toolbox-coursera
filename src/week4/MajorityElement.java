package week4;

import java.util.*;
import java.io.*;

/**
 * Goal is to check whether input array has a majority sequence
 */
public class MajorityElement {


    /**
     * Should recursively call itself to get if element is majority one.
     * Done using hashmap.
     *
     * There is more complicated way of using a divide and conquer hashmap. :)
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int getMajorityElement(int[] a, int left, int right) {
        Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
        
        for(int i = left; i < right; i++) {
            if(arrMap.containsKey(a[i]))
                arrMap.put(a[i], arrMap.get(a[i])+1);
            arrMap.putIfAbsent(a[i], 1);
        }

        for (Integer value : arrMap.values()) {
            if(value > a.length/2)
                return 1;
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
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

