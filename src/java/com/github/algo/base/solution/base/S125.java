package com.github.algo.base.solution.base;

public class S125 {

    //A-Z 65-90
    //a-z 97-122
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;


        //compare two char on the specified position
        while (left < right && left >= 0 && left < s.length() && right >= 0 && right < s.length()) {
            //jump over the chars that is not a alphabet
            while (!isAlphBet(chars[left])) {
                left++;
                break;
            }
            //jump over the chars that is not a alphabet
            while (!isAlphBet(chars[right])) {
                right--;
                break;
            }

            int abs = Math.abs(chars[left] - chars[right]);
            if (abs != 0 && abs != 32) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphBet(char aChar) {
        return (aChar >= 65 && aChar <= 90) || (aChar >= 97 && aChar <= 122);
    }

    public static void main(String[] args) {
        System.out.println('z' - 0);
    }
}
