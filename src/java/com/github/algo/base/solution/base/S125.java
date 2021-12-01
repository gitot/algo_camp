package com.github.algo.base.solution.base;

public class S125 {


    //todo

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0, right = len - 1;
        while (left < right && left >= 0 && left < len && right >= 0 && right < len){
            while (!isAlphBet(chars[left])) {
                left++;
            }
            while (!isAlphBet(chars[right])) {
                right--;
            }
            if (left < right) {
                int div = chars[left] - chars[right];
                if (Math.abs(div) != 0 && Math.abs(div) != 32) {
                    return false;
                }
            } else {
                return true;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphBet(char aChar) {
        return (aChar >= 65 && aChar <= 80) || (aChar >= 97 && aChar <= 122);
    }


    public static void main(String[] args) {
        System.out.println(new S125().isPalindrome(" "));

    }
}
