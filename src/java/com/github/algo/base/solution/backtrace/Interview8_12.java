package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview8_12 {


    List<List<String>> res = new ArrayList();
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }
        backTrace(chess, 0);
        return res;
    }

    private void backTrace(char[][] chess, int i) {
        if (i >= n) {
            List<String> answer = new ArrayList<>();
            for (int a = 0; a < n; a++) {
                answer.add(new String(chess[a]));
            }
            res.add(answer);
            return;
        }

        for (int j = 0; j < n; j++) {
            boolean isOk = isOk(chess, i, j);
            if (isOk) {
                chess[i][j] = 'Q';
                backTrace(chess, i + 1);
                chess[i][j] = '.';
            }
        }
    }

    private boolean isOk(char[][] chess, int i, int j) {
        //check if there is any queue at the same column on previous rows
        for (int x = 0; x < i; x++) {
            if (chess[x][j] == 'Q') return false;
        }

        //check if there is any queue on the diagonal in the direction of
        //from bottom-right to top-left
        for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
            if (chess[x][y] == 'Q') return false;
        }

        //check if there is any queue on the diagonal in the direction of
        //from bottom-left to top-right
        for (int x = i - 1, y = j + 1; x >= 0 && y < n; x--, y++) {
            if (chess[x][y] == 'Q') return false;
        }

        return true;
    }

}
