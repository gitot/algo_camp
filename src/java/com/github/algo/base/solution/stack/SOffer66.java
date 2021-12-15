package com.github.algo.base.solution.stack;

import java.util.Stack;

public class SOffer66 {



    public static void main(String[] args) {

    }

    class CQueue {

        public CQueue() {

        }

        private Stack<Integer> data = new Stack<>();
        private Stack<Integer> tmp = new Stack<>();


        public void appendTail(int value) {
            data.push(value);
        }

        public int deleteHead() {
            if (data.size() == 0) return -1;
            while (data.size() > 0) {
                tmp.push(data.pop());
            }
            Integer res = tmp.pop();
            while (tmp.size() > 0) {
                data.push(tmp.pop());
            }
            return res;
        }
    }
}
