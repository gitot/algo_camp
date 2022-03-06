package com.github.algo.base.solution.xfs.dfs;

public class Offer13 {
    private int count;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(visited, 0, 0, k, m, n);
        return count;
    }

    private void dfs(boolean[][] visited, int m, int n, int k, int mm, int nn) {
        visited[m][n] = true;
        count++;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < directions.length; i++) {
            int x = directions[i][0] + m;
            int y = directions[i][1] + n;
            if (x >= 0 && y >= 0 && x < mm && y < nn && !visited[x][y] && check(x, y, k)) {
                dfs(visited, x, y, k, mm, nn);
            }
        }
    }

    private boolean check(int m, int n, int k) {
        int sumM = sumEveryDigit(m);
        int sumN = sumEveryDigit(n);
        return sumM + sumN <= k;
    }

    private int sumEveryDigit(int num) {
        int res = 0;
        while (num != 0) {
            res += (num % 10);
            num /= 10;
        }
        return res;
    }
}
