package com.github.algo.base.solution.bs;

public class S69 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int next = mid + 1;
            long midSquare = ((long) mid) * mid;
            long nextSquare = ((long) (mid + 1)) * (mid + 1);
            if (midSquare <= x && nextSquare > x) {
                return mid;
            } else if (midSquare < x && nextSquare <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
