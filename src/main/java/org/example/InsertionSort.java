package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class InsertionSort {
    //bestCase O(n)
    //worstCase O(n*n)
    //averageCase O(n*n)

    public static void sort(ArrayList<Double> a) {
        int n = a.size();
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a.get(j), a.get(j - 1)); j--) {
                exch(a, j, j-1);
            }
        }
    }
    private static boolean less(Double v, Double w)
    { return v.compareTo(w) < 0; }
    private static void exch(ArrayList<Double> a, int i, int j)
    {
        Double swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }

}

