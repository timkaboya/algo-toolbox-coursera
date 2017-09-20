package week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Problem 2: Maximizing Loot
 * Thief finds more loot than his bag can fit. Find most valuable combo of items
 * assuming any fraction of a loot item can be put in the bag.
 *
 * Algo for FractionalKnapsack problem.
 *
 *
 */
public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int len = values.length;
        // Bounds checking
        if(values.length == 0 || weights.length == 0 || capacity <= 0)
            return 0;

        // Sort all arrays based on weighted values.
        Double [][] valsAndWeights = new Double[len][3];  // 2D array for all vals.

        double [] weightedVals = new double[len];
        for(int i=0; i<values.length; i++) {
            weightedVals[i] = values[i]/(weights[i]*1.0);
            valsAndWeights[i][0] = weightedVals[i];
            valsAndWeights[i][1] = (double)values[i];
            valsAndWeights[i][2] = (double) weights[i];
        }

        // Sorting array by Col 0
        sort2DArray(valsAndWeights, 0);

        // Picking from sorted weights
        int i = len - 1;
        double weiVal, sumWeights = 0;
        while(sumWeights < capacity && i >= 0) {
            // Pick most valued item and add as much to get to req capacity.
            weiVal = valsAndWeights[i][0] * valsAndWeights[i][2];
            value = weiVal + value;
            sumWeights = sumWeights + valsAndWeights[i][2];
            while(sumWeights > capacity) {
                value = value - (valsAndWeights[i][0]);
                sumWeights--;
            }

            if(sumWeights == capacity)
                break;
            i--;
        }
        return value;
    }
    private static void sort2DArray(Double [][] arr, int col) {
        // Sort 2D array by value weightedVals.
        final Comparator<Double[]> arrayComparator = new Comparator<Double[]>() {
            @Override
            public int compare(final Double[] entry1, final Double[] entry2) {
                return entry1[col].compareTo(entry2[col]);
            }
        };
        Arrays.sort(arr, arrayComparator);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

    private static void display2DArray(Object [][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
} 
