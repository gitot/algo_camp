package com.github.algo.base.solution.stack;

import java.util.Stack;

public class SInterview03_05 {
    class SortedStack {
        private Stack<Integer> data;
        private Stack<Integer> tmp;

        public SortedStack() {
            this.data = new Stack<>();
            this.tmp = new Stack<>();
        }

        public void push(int val) {
            while (!data.isEmpty() && data.peek() < val) {
                tmp.push(data.pop());
            }
            data.push(val);
            while (!tmp.isEmpty()) {
                data.push(tmp.pop());
            }
        }

        public void pop() {
            if (data.isEmpty()) {
                return;
            }
            data.pop();
        }

        public int peek() {
            if (data.isEmpty()) {
                return -1;
            }
            return data.peek();
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }
    }
}
