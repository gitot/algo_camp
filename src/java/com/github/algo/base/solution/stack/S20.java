package com.github.algo.base.solution.stack;

import java.util.Stack;

public class S20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char cur = chars[i];
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            Character before = stack.peek();
            if (match(before.charValue(), cur)) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }

        return stack.isEmpty();
    }

    private boolean match(char left, char right) {
        if (left == '[' && right == ']') return true;
        if (left == '{' && right == '}') return true;
        if (left == '(' && right == ')') return true;
        return false;
    }
}
