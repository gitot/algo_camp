package com.github.algo.base.solution.patttern;

public class S48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int left = 0, right = len - 1; //control scope in the horizon direction in which ratating is performed
        int layer = 0;


        //ratate layer by layer
        while (layer < matrix.length / 2) {
            int tmp = matrix[layer][left];

// TODO: 1/3/2022

            layer++;
            left++;
            right--;
        }
    }
}
