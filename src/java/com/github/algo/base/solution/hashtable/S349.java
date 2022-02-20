package com.github.algo.base.solution.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int s : nums1) {
            s1.add(s);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int i : nums2) {
            s2.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : s1) {
            if (s2.contains(integer)) {
                list.add(integer);
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
