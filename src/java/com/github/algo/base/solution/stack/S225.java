package com.github.algo.base.solution.stack;

import java.util.LinkedList;
import java.util.Queue;

public class S225 {
    class MyStack {

        public MyStack() {

        }

        Queue<Integer> data = new LinkedList<>();
        Queue<Integer> tmp = new LinkedList<>();

        public void push(int x) {
            data.offer(x);
        }

        public int pop() {
            while (data.size() > 1) {
                tmp.offer(data.poll());
            }
            Integer res = data.poll();
            while (tmp.size() > 0) {
                data.offer(tmp.poll());
            }
            return res;
        }

        public int top() {
            while (data.size() > 1) {
                tmp.offer(data.poll());
            }
            Integer res = data.poll();
            while (tmp.size() > 0) {
                data.offer(tmp.poll());
            }
            data.offer(res);
            return res;
        }

        public boolean empty() {
            return data.size() <= 0;
        }
    }
}
