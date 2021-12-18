package com.github.algo.base.solution.stack;

import java.util.Stack;

public class S1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }


        char[] res = new char[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index--;
        }
        return new String(res);
    }
}
