package com.github.algo.base.exercise;

public class S542_01 {
    public int[][] updateMatrix(int[][] mat) {

        //todo a timeout solution
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = dfs(mat,i, j);
            }
        }

        return res;
    }

    private int dfs(int[][] mat, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length) {
            return 0;
        }
        if (mat[i][j] == 0) return 0;

        int[] x = new int[]{-1, 1, 0, 0};
        int[] y = new int[]{0, 0, -1, 1};

        int res = 1;

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            min = Math.min(dfs(mat, i + x[k], j + y[k]), min);
        }

        res += min;

        return res;
    }
}
