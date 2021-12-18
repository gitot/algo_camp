package com.github.algo.base.solution.stack;

import java.util.Stack;


public class SInterview16_26 {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> symbols = new Stack<>();

        char[] charArray = s.toCharArray();
        int len = charArray.length;

        //calculate multiply and divide first
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (isNumber(charArray[i])) {
                continue;
            }
            Integer num = Integer.valueOf(s.substring(start, i + 1));
            nums.push(num);
            start = i + 1;
            if (isMultiplyOrDivide(charArray[i]) ) {

            }
        }

        //todo
        return 0;
        //calculate

    }

    private boolean isMultiplyOrDivide(char c) {
        return c == '*' || c == '/';
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
