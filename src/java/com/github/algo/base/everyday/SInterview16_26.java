package com.github.algo.base.everyday;

import java.util.Stack;

public class SInterview16_26 {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int len = s.length();

        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int numberChars = 0;
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (isNumber(cur)) {
                numberChars++;
                if (i == len - 1) {
                    String num = s.substring(i + 1 - numberChars, i + 1);
                    nums.push(new Integer(num));
                }
                continue;
            }

            String num = s.substring(i - numberChars, i);
            nums.push(new Integer(num));

            while (!ops.isEmpty() && canCalculate(ops.peek(), cur)) {
                int res = operatePrevious(nums, ops);
                nums.push(res);
            }
            ops.push(cur);

            numberChars = 0;

        }
        if (ops.size() <= 0) {
            return nums.pop();
        } else if (ops.size() > 1) {
            int operatePrevious = operatePrevious(nums, ops);
            nums.push(operatePrevious);
            return operatePrevious(nums, ops);
        } else {
            return operatePrevious(nums, ops);
        }
    }

    private int operatePrevious(Stack<Integer> nums, Stack<Character> ops) {
        Character prevOp = ops.pop();
        Integer behind = nums.pop();
        Integer before = nums.pop();
        return calculate(before, behind, prevOp);
    }

    private int calculate(Integer before, Integer behind, char prev) {
        if (prev == '+') {
            return before + behind;
        } else if (prev == '-') {
            return before - behind;
        } else if (prev == '*') {
            return before * behind;
        } else {
            return before / behind;
        }
    }

    private boolean canCalculate(char prev, char cur) {
        if ((prev == '+' || prev == '-') && (cur == '*' || cur == '/')) {
            return false;
        }
        return true;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        int calculate = new SInterview16_26().calculate("1*2-3/4+5*6-7*8+9/10");
        System.out.println();

    }

}
