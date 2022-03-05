package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.List;

public class S22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        char[] chars = new char[n * 2];
        backTrace(0, chars, 0, n);
        return res;
    }

    private void backTrace(int i, char[] chars, int leftParenthesesCount, int n) {
        if (i >= chars.length) {
            res.add(new String(chars));
            return;
        }

        //more right parentheses than left parentheses
        if (i - leftParenthesesCount > leftParenthesesCount) {
            return;
        }


        if (leftParenthesesCount >= n) {
            chars[i] = ')';
            backTrace(i + 1, chars, leftParenthesesCount, n);
            return;
        }
        chars[i] = '(';
        leftParenthesesCount++;
        backTrace(i + 1, chars, leftParenthesesCount, n);
        leftParenthesesCount--;
        chars[i] = ')';
        backTrace(i + 1, chars, leftParenthesesCount, n);
    }
}
