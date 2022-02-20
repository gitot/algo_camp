package com.github.algo.base.solution.hashtable;

import java.util.Arrays;

public class S706 {

    class MyHashMap {

        int[] elements = new int[10000001];

        public MyHashMap() {
            Arrays.fill(elements, -1);
        }

        public void put(int key, int value) {
            elements[key] = value;
        }

        public int get(int key) {
            return elements[key];
        }

        public void remove(int key) {
            elements[key] = -1;
        }
    }

}
