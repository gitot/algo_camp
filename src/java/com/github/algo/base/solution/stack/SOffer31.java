package com.github.algo.base.solution.stack;

import com.github.algo.base.solution.base.Utils;

import java.util.Stack;

public class SOffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //index of the element to be popped
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            while (!stack.isEmpty() && stack.peek().equals(popped[index])) {
                stack.pop();
                index++;
            }
            stack.push(pushed[i]);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(popped[index])) {
                return false;
            }
            index++;
        }

        return true;
    }

    public static void main(String[] args) {
        SOffer31 s = new SOffer31();
        s.validateStackSequences(Utils.createArray("[1,2,3,4,5]"), Utils.createArray("[4,5,3,2,1]"));
    }

}
