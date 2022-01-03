package com.github.algo.base.solution.patttern;


public class SInterview16_04 {

    public String tictactoe(String[] board) {
        int len = board.length;
        char[][] matrix = new char[len][len];

        //convert string array to char matrix
        for (int i = 0; i < len; i++) {
            matrix[i] = board[i].toCharArray();
        }

        //test if someone win at every row
        for (int i = 0; i < len; i++) {
            char firstChar = matrix[i][0];
            if (firstChar == ' ') continue;
            int j;
            for (j = 1; j < len; j++) {
                if (matrix[i][j] != firstChar) break;
            }
            if (j >= len) return String.valueOf(firstChar);
        }


        //test if someone win at every column
        for (int i = 0; i < len; i++) {
            char firstChar = matrix[0][i];
            if (firstChar == ' ') continue;
            int j;
            for (j = 1; j < len; j++) {
                if (matrix[j][i] != firstChar) break;
            }
            if (j >= len) return String.valueOf(firstChar);
        }


        char topLeftChar = matrix[0][0];
        if (topLeftChar != ' ') {
            int i;
            for (i = 1; i < len; i++) {
                if (topLeftChar != matrix[i][i]) break;
            }
            if (i >= len) {
                return String.valueOf(topLeftChar);
            }
        }

        char topRightChar = matrix[0][len - 1];
        if (topRightChar != ' ') {
            int x = 1;
            int y = len - 2;
            for (; x < len; x++, y--) {
                if (topRightChar != matrix[x][y]) break;
            }
            if (x >= len) return String.valueOf(topRightChar);
        }

        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                if (matrix[a][b] == ' ') return "Pending";
            }
        }

        return "Draw";



    }


    public static void main(String[] args) {

        String argument = "[\"   X O  O \",\" X X    O \",\"X  X    O \",\"X    OX O \",\"X   XO  O \",\"X  X O  O \",\"O  X O  O \",\"     O  OX\",\"     O  O \",\"   X XXXO \"]";

    }

}
