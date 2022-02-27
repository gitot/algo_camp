package com.github.algo.base.solution.bt.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class S295 {
    class MedianFinder {

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        public MedianFinder() {

        }
        /**
         * It is guaranteed that there will never be fewer elements in maxHeap then those in minHeap.
         */
        public void addNum(int num) {
            if (minHeap.size() > 0 && minHeap.peek() < num) minHeap.offer(num);
            else maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (((double) maxHeap.peek()) + minHeap.peek()) / 2;
        }

    }
}
