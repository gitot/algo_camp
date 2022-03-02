package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.List;

public class S17 {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        if (chars.length <= 0) return res;
        char[] path = new char[chars.length];
        backTrace(chars, 0, path);
        return res;
    }

    private void backTrace(char[] chars, int i, char[] path) {
        if (i >= chars.length) {
            res.add(new String(path));
            return;
        }
        char[] digits = map(chars[i]);
        for (int k = 0; k < digits.length; k++) {
            path[i] = digits[k];
            backTrace(chars, i + 1, path);
        }
    }

    private char[] map(char aChar) {
        switch (aChar) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return null;
        }
    }
}
