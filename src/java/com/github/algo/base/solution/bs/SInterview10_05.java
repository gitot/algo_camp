package com.github.algo.base.solution.bs;

public class SInterview10_05 {
    public int findString(String[] words, String s) {
        int len = words.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].equals("")) {
                if (words[left].equals(s)) {
                    return left;
                }
                left++;
            } else if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
