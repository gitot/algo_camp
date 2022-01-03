package com.github.algo.base.solution.patttern;

public class S240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // TODO: 1/3/2022  

        int row = 0, col = 0;
        while (row < rows || col < cols) {
            if (matrix[row][col] == target) return true;
            if (row < rows - 1) {
                row++;
                continue;
            }
            if (col < cols - 1) {
                col++;
                continue;
            }
        }

        return false;
    }
}
