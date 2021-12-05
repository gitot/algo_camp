package com.github.algo.base.solution.patttern;

/**
 * Why can't I find this kind of simple regulation
 * to solve the problem?
* */
public class SInterview01_08 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int rows = matrix.length;
        if (rows <= 0) return;
        int cols = matrix[0].length;

        //is there zero in each row
        boolean[] r = new boolean[rows];
        //is there zero in each col
        boolean[] c = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }

        //set zero if there is any zero
        // in the specified row or col
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (r[i] || c[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        SInterview01_08 s = new SInterview01_08();
    }

}
