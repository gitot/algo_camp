package com.github.algo.base.solution.xfs.dfs;

import java.util.ArrayList;
import java.util.List;

public class Interview16_19 {
    List<Integer> list = new ArrayList<>();
    int tmp = 0;
    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] != 0 ) continue;
                dfs(land, i, j, m, n);
                list.add(tmp);
                tmp = 0;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int[][] land, int i, int j, int m, int n) {
        if (land[i][j] != 0) return;
        tmp++;
        land[i][j] = 1;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        for (int k = 0; k < directions.length; k++) {
            int x = directions[k][0] + i;
            int y = directions[k][1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                dfs(land, x, y, m, n);
            }
        }
    }
}
