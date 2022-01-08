package com.github.algo.base.solution.stack;

import java.util.Stack;

public class S42 {
    public int trap(int[] height) {
        int len = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int floodedHeight = Math.min(height[stack.peek()], height[i]) - height[cur];
                int distance = i - stack.peek() - 1;
                res += distance * floodedHeight;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        new S42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
