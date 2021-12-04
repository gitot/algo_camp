package com.github.algo.base.solution.base;

/**
 * 0. please understand the question firstly(improve English)
 * 1. no need to know the int value that represents the char
 * 2. no need to use nested loop
 */
public class S125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!isAlphBetOrNumber(chars[left])) {
                left++;
                continue;
            }
            if (!isAlphBetOrNumber(chars[right])) {
                right--;
                continue;
            }
            if (toLower(chars[left]) != toLower(chars[right])) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private char toLower(char c) {
        if (c >= 'a' && c <= 'z') return c;
        if (c >= '0' && c <= '9') return c;
        return (char) (c + 32);
    }

    private boolean isAlphBetOrNumber(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println('z' - 0);
    }
}
