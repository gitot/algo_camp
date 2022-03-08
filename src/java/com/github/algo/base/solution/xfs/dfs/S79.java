package com.github.algo.base.solution.xfs.dfs;

public class S79 {

    boolean existed;

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;

        //preform DFS starting at each node
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                dfs(board, visited, 0, i, j, m, n, word);
                if (existed) return true;
            }
        }

        return existed;
    }

    private void dfs(char[][] board, boolean[][] visited, int step, int i, int j, int m, int n, String word) {
        if (existed) return;
        if (board[i][j] != word.charAt(step)) {
            return;
        }
        visited[i][j] = true;
        if (step == word.length() - 1) {
            existed = true;
            return;
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            int x = directions[k][0] + i;
            int y = directions[k][1] + j;
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                dfs(board, visited, step + 1, x, y, m, n, word);
            }
        }
        visited[i][j] = false;
    }

}
