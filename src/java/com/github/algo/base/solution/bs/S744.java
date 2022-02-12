package com.github.algo.base.solution.bs;

public class S744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 && letters[mid] > target) {
                return letters[mid];
            } else if (letters[mid] > target && letters[mid - 1] <= target) {
                return letters[mid];
            } else if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return letters[0];
    }

}
