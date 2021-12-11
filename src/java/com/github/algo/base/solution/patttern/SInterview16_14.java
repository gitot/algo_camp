package com.github.algo.base.solution.patttern;


public class SInterview16_14 {


    public String tictactoe(String[] board) {
        //todo
        int len = board.length;
        char[][] bd = new char[len][len];
        for (int i = 0; i < len; i++) {
            bd[i] = board[i].toCharArray();
        }

        //Horizontal inspection
        for (int i = 0; i < len; i++) {
            char first = bd[i][0];
            if (first == ' ') continue;
            int j = 0;
            for (j = 1; j < len; j++) {
                if (bd[i][j] != first) break;
            }
            if (j >= len) return String.valueOf(first);
        }

        //Longitudinal inspection
        for (int j = 0; j < len; j++) {
            char first = bd[0][j];
            if (first == ' ') continue;
            int i = 0;
            for (i = 1; i < len; i++) {
                if (bd[i][j] != first) break;
            }
            if (i >= len) return String.valueOf(first);
        }

        //Diagonal check
        char a = bd[0][0];
        if (a != ' ') {
            int i;
            for (i = 1; i < len; i++) {
                if (bd[i][i] != a) {
                    break;
                }
            }
            if (i >= len) {
                return String.valueOf(a);
            }
        }
        char b = bd[0][len - 1];
        if (b != ' ') {
            int i;
            for (i = 0; i < len; i++) {
                for (int j = len - 1; j >= 0; j--) {
                    if (bd[i][i] != b) break;
                }
            }
            if (i >= len) return String.valueOf(b);

        }


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (bd[i][j] == ' ') return "Pending";
            }
        }

        return "Draw";
    }


    public static void main(String[] args) {
        SInterview16_14 s = new SInterview16_14();
//        s.tictactoe(new String[]{"OX ", "OX ", "O  "});
//        s.tictactoe(new String[]{" O    X"," O     ","     O ","XXXXXXX","  O    "," O   O ","O  X OO"});
        s.tictactoe(new String[]{"O X", " XO", "X O"});
    }
}
