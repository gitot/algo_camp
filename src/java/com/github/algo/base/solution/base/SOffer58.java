package com.github.algo.base.solution.base;

public class SOffer58 {
    public String reverseLeftWords(String s, int n) {
        char[] charArray = s.toCharArray();

        int len = charArray.length;

        //backup sub array to be covered
        char[] r = new char[n];
        for (int i = 0; i < n; i++) {
            r[i] = charArray[i];
        }

        //move reminder to left
        for (int i = n; i < len; i++) {
            charArray[i - n] = charArray[i];
        }

        //copy backup onto right of the new char array
        for (int i = len - n, j = 0; i < len; i++, j++) {
            charArray[i] = r[j];
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        SOffer58 s = new SOffer58();
        System.out.println(s.reverseLeftWords(" ab ", 2));
    }

}
