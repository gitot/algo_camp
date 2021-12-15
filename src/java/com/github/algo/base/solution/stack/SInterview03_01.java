package com.github.algo.base.solution.stack;

public class SInterview03_01 {

    class TripleInOne {

        private int[] data;
        private int stackSize;

        //the initial index for next element in every stack to push at
        private int[] initialPositions = new int[3];
        //the index for next element in every stack to push at
        private int[] positions = new int[3];

        public TripleInOne(int stackSize) {
            data = new int[stackSize * 3];
            positions[1] = stackSize;
            initialPositions[1] = stackSize;
            positions[2] = stackSize * 2;
            initialPositions[2] = stackSize * 2;
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            boolean isFull = isFull(stackNum);
            if (isFull) {
                return;
            }
            data[positions[stackNum]] = value;
            positions[stackNum]++;
        }

        public int pop(int stackNum) {
            boolean empty = isEmpty(stackNum);
            if (empty) return -1;
            int res = data[positions[stackNum] - 1];
            positions[stackNum]--;
            return res;
        }

        public int peek(int stackNum) {
            boolean empty = isEmpty(stackNum);
            if (empty) return -1;
            return data[positions[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return positions[stackNum] <= initialPositions[stackNum];
        }

        private boolean isFull(int stackNum) {
            return positions[stackNum] >= initialPositions[stackNum] + stackSize;
        }
    }
}
