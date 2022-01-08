package com.github.algo.base.solution.recursion;

public class SOffer10_1 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int left = 0, right = 1;
        int res = left + right;
        for (int i = 2; i <= n; i++) {
            res = (left + right) % 1000000007;
            left = right;
            right = res;
        }
        return res;
    }
}
