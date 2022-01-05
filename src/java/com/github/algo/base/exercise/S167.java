package com.github.algo.base.exercise;

public class S167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        //never expect this
        return null;
    }
}
