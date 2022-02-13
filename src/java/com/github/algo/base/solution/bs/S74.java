package com.github.algo.base.solution.bs;

public class S74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int elements = rows * cols;
        int left = 0, right = elements - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            //transform mid to 2-dimension coordination
            int row = mid / cols;
            int col = mid - row * cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
