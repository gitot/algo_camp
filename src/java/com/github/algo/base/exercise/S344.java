package com.github.algo.base.exercise;

public class S344 {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }
}
