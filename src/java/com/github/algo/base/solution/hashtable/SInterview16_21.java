package com.github.algo.base.solution.hashtable;

import java.util.Set;
import java.util.TreeSet;

public class SInterview16_21 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> s1 = new TreeSet<>(), s2 = new TreeSet<>();
        for (int i : array1) {
            sum1 += i;
            s1.add(i);
        }
        for (int i : array2) {
            sum2 += i;
            s2.add(i);
        }

        if (sum1 == sum2 || Math.abs(sum1 - sum2) % 2 != 0) {
            return new int[0];
        }
        if (sum2 - sum1 > 0) {
            //exchange a smaller in arr1 for a bigger in arr2
            int diff = (sum2 - sum1) / 2;
            for (Integer integer : s1) {
                if (s2.contains(integer + diff)) {
                    return new int[]{integer, integer + diff};
                }
            }
        } else {
            //exchange a smaller in arr2 for a bigger in arr1
            int diff = (sum1 - sum2) / 2;
            for (Integer integer : s2) {
                if (s1.contains(integer + diff)) {
                    return new int[]{integer + diff, integer};
                }
            }
        }
        return new int[0];
    }

}
