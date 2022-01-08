package com.github.algo.base.solution.recursion;

/**
 * Why should use long here?
 */
public class SInterview08_01 {
    public int waysToStep(int n) {
        if (n < 3) return n;
        if (n == 3) return 4;

        long a = 1, b = 2, c = 4, res = a + b + c;
        for (int i = 4; i <= n; i++) {
            res = a + b + c ;
            res %= 1000000007;
            a = b;
            b = c;
            c = res;
        }

        return (int)res;
    }

}
