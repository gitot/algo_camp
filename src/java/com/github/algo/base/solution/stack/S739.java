package com.github.algo.base.solution.stack;

import java.util.Stack;

public class S739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        int len = temperatures.length;

        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while (stack.size() > 0 && temperatures[stack.peek()] < temperature) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = new S739().dailyTemperatures(temperatures);
        System.out.println(ints);

    }
}
