package com.github.algo.base.solution.stack;

import java.util.Stack;

public class S155 {
    class MinStack {
        private Stack<Integer> data;
        private Stack<Integer> min;

        public MinStack() {
            this.data = new Stack<>();
            this.min = new Stack<>();
            this.min.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            data.push(val);
            Integer min = this.min.peek();
            if (val <= min) {
                this.min.push(val);
            } else {
                this.min.push(min);
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
