package com.github.algo.base.solution.backtrace;

public class S37 {
    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][][] subBoard = new boolean[3][3][10];
    boolean solved = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                rows[i][num] = true;
                cols[j][num] = true;
                subBoard[i / 3][j / 3][num] = true;
            }
        }
        backTrace(board, 0, 0);
    }

    private void backTrace(char[][] board, int i, int j) {
        if (i >= 9) {
            solved = true;
            return;
        }


        if (board[i][j] != '.') {
            int nextRow = i, nextCol = j + 1;
            if (j >= 8) {
                nextRow++;
                nextCol = 0;
            }
            backTrace(board, nextRow, nextCol);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (rows[i][num] || cols[j][num] || subBoard[i / 3][j / 3][num]) {
                    continue;
                }
                board[i][j] = (char) (num + '0');
                rows[i][num] = true;
                cols[j][num] = true;
                subBoard[i / 3][j / 3][num] = true;
                int nextRow = i, nextCol = j + 1;
                if (j >= 8) {
                    nextRow++;
                    nextCol = 0;
                }
                backTrace(board, nextRow, nextCol);
                if (solved) {
                    return;
                }
                rows[i][num] = false;
                cols[j][num] = false;
                subBoard[i / 3][j / 3][num] = false;
                board[i][j] = '.';  //why this is necessary?
            }
        }
    }

}
