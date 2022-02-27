package com.github.algo.base.solution.bt.heap;

import java.util.*;

public class S347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> times = new HashMap<>();
        for (int num : nums) {
            times.put(num, times.getOrDefault(num, 0) + 1);
        }
        //construct a max top heap ordered by frequency
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        times.entrySet().forEach(e -> queue.offer(e));

        //record unique number of the top frequent elements
        List<Integer> list = new ArrayList<>();
        while (list.size() < k) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            list.add(poll.getKey());
        }

        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
