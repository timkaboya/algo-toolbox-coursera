package week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for(int j = i+1; j < n; j++) {
                if (result < ( (long) numbers[i] * numbers [j]))
                    result = (long) numbers[i] * numbers[j];
            }
        }

        return result;
    }

    static Long getMaxPairwiseProductFast(int[] numbers) {
        long result;
        int n = numbers.length;
        int maxIndex1 = -1, maxIndex2 = -1;
        for (int i = 0; i < n; ++i) {
            if ((maxIndex1 == -1) || (numbers[i] > numbers[maxIndex1])) {
                maxIndex1 = i;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (i != maxIndex1) {
                if ((maxIndex2 == -1) || (numbers[i] > numbers[maxIndex2]))
                    maxIndex2 = i;
            }
        }

        result = ((long) numbers[maxIndex1]) * numbers[maxIndex2];

        return result;
    }

    public static void main(String[] args) {

        Random rand = new Random();
        /* Stress Testing to test our program */
        /*
        while (true) {
            int len = rand.nextInt(1000) + 2;
            System.out.println("Len: " + len);
            int [] numbers = new int[len];
            for (int i = 0; i < len; i++) {
                numbers[i] = rand.nextInt(100000);
            }
            for (int i = 0; i < len; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            long res1 = getMaxPairwiseProduct(numbers);
            long res2 = getMaxPairwiseProductFast(numbers);

            if (res1 != res2) {
                System.out.println("Wrong Answer: " + res1 + " " + res2);
                break;
            } else
                System.out.println("OK! ");

        }
        */

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
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
