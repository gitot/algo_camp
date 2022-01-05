package com.github.algo.base.exercise;

public class S557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        if (len <= 1) return s;

        int left = 0, right = left + 1;

        while (right < len) {
            if (right == len - 1) {
                reverse(chars, left, right);
                break;
            }
            if (chars[right] != ' ') {
                right++;
                continue;
            }
            reverse(chars, left, right - 1);
            left = right + 1;
            right = left + 1;
        }


        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
