
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        int max = 0, max2 = 0;
        for (int i = 0; i < n; ++i) {
            if (numbers[i] > max) {
                max2 = max;
                max = numbers[i];
            }
            if ((numbers[i] > max2) && (numbers[i] < max))
                max2 = numbers[i];
        }
        result = (long) max * max2;

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
