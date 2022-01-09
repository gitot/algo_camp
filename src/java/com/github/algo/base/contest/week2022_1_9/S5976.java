package com.github.algo.base.contest.week2022_1_9;

import java.util.HashSet;
import java.util.Set;

public class S5976 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(matrix[i][j]);
            }
            if (set.size() < n) {
                return false;
            }
            set.clear();

            for (int j = 0; j < n; j++) {
                set.add(matrix[j][i]);
            }
            if (set.size() < n) {
                return false;
            }
            set.clear();
        }


        return true;
    }
}
