package com.github.algo.base.solution.xfs.dfs;

public class S200 {
    int res;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int k = 0; k < directions.length; k++) {
            int x = directions[k][0] + i;
            int y = directions[k][1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                dfs(grid, x, y, m, n);
            }
        }
    }
}
