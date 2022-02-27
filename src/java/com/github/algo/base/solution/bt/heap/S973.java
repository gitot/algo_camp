package com.github.algo.base.solution.bt.heap;

import java.util.*;

public class S973 {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Entry> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getKey() - o2.getKey() < 0) {
                return -1;
            } else {
                return 1;
            }
        });
        for (int[] point : points) {
            int x = Math.abs(point[0]);
            int y = Math.abs(point[1]);
            double sqrt = Math.sqrt(x * x + y * y);
            queue.offer(new Entry(sqrt, point));
        }


        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Entry poll = queue.poll();
            list.add(poll.getValue());
        }

        int size = list.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }

        return res;
    }


    static class Entry {
        double key;
        int[] value;

        public Entry(double key, int[] value) {
            this.key = key;
            this.value = value;
        }

        public double getKey() {
            return key;
        }

        public int[] getValue() {
            return value;
        }
    }


    public static void main(String[] args) {
        int[][] param = new int[][]{{1, 3}, {-2, 2}};
        new S973().kClosest(param, 1);
    }
}
