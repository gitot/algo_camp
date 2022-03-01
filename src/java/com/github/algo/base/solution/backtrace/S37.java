package com.github.algo.base.solution.backtrace;

import java.util.HashSet;
import java.util.Set;

public class S37 {

    // TODO: 3/1/2022 unsolved

    int dotCount = 0;
    int length = 0;

    public void solveSudoku(char[][] board) {
        this.length = board.length;
        for (int i = 0; i < length; i++) {
            char[] chars = board[i];
            for (char aChar : chars) {
                if (aChar == '.') dotCount++;
            }
        }
        backTrace(board, 0, 0, 0);
    }

    private void backTrace(char[][] board, int i, int j, int filled) {
        if (i >= board.length) {
            return;
        }

        if (board[i][j] != '.') {
            if (j + 1 >= board.length) {
                backTrace(board, i + 1, j, filled);
            } else {
                backTrace(board, i, j + 1, filled);
            }
            return;
        }

        for (int d = 1; d <= 9; d++) {
            board[i][j] = (char) ('0' + d);
            boolean isOk = isOk(board, i, j, d);
            if (isOk) {
                if (dotCount - 1 == filled) {
                    return;
                }
                if (j + 1 >= board.length) {
                    backTrace(board, i + 1, j, filled + 1);
                } else {
                    backTrace(board, i, j + 1, filled + 1);
                }
            }
        }
    }

    private boolean isOk(char[][] board, int i, int j, int d) {
        //check on each previous row
        for (int x = 0; x < i; x++) {
            boolean boo = checkEachRow(board[x], 0, board.length - 1);
            if (!boo) {
                return false;
            }
        }
        boolean boo = checkEachRow(board[i], 0, j);
        if (!boo) {
            return false;
        }

        //check on each previous column
        Set<Character> set = new HashSet<>();
        for (int y = 0; y <= j; y++) {
            for (int x = 0; x <= i; x++) {
                set.add(board[x][y]);
            }
            if (set.size() != i + 1) {
                return false;
            }
            set.clear();
        }

        if (i < 2 || j < 2) return true;

        //check each sub-board
        set.clear();
        for (int x = 0; x <= i - 2; x++) {
            for (int y = 0; y <= j - 2; y++) {
                for (int a = 0; a < x + 3; a++) {
                    for (int b = 0; b < y + 3; b++) {
                        set.add(board[a][b]);
                    }
                }
                if (set.size() != 9) return false;
                set.clear();
            }
        }

        return true;
    }

    private boolean checkEachRow(char[] chars, int start, int end) {
        if (end <= start) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        return set.size() == end - start + 1;
    }
}
