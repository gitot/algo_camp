package com.github.algo.base.solution.hashtable;

import java.util.*;

public class S1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> m = new TreeMap();
        Set<Integer> s = new LinkedHashSet<>();
        for (int i : arr2) s.add(i);
        for (int i : arr1) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }

        int[] res = new int[arr1.length];
        int length = arr1.length;
        for (int i = 0; i < length; ) {
            for (Integer integer : s) {
                Integer times = m.get(integer);
                for (Integer t = 0; t < times; t++) {
                    res[i++] = integer;
                }
                m.remove(integer);
            }
            for (Map.Entry<Integer, Integer> integerIntegerEntry : m.entrySet()) {
                Integer times = m.get(integerIntegerEntry.getKey());
                for (Integer t = 0; t < times; t++) {
                    res[i++] = integerIntegerEntry.getKey();
                }
            }
        }
        return res;
    }
}
