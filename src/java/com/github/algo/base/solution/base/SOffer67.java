package com.github.algo.base.solution.base;

public class SOffer67 {
    public int strToInt(String str) {
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        int i = 0;

        //skip space at the beginning
        while (i < len && charArray[i] == ' ') i++;

        //return 0 if there is no valid char
        if (i >= len) return 0;

        //deal with first char
        int sign = 1;   //integer sign
        if (isNumber(charArray[i])) {
            sign = 1;
        } else if (charArray[i] == '-') {
            sign = -1;
            i++;
        } else if (charArray[i] == '+') {
            sign = 1;
            i++;
        }else {
            return 0;
        }

        //return 0 if there is only a '-' or '+' behind space
        if (i >= len) return 0;

        int maxHigh = 214748364;
        int result = 0;//positive representation
        while (i < len && isNumber(charArray[i])) {
            char cur = charArray[i];//todo rename this variable

            if (result > maxHigh) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (result == maxHigh) {
                if (sign == -1) {
                    if (cur >= '8') return Integer.MIN_VALUE;
                } else {
                    if (cur >= '7') return Integer.MAX_VALUE;
                }
            }

            result = result * 10 + (cur - '0');
            i++;
        }

        return result * sign;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        SOffer67 s = new SOffer67();
        System.out.println(s.strToInt(""));   //0
        System.out.println(s.strToInt(" "));//0
        System.out.println(s.strToInt("  "));//0
        System.out.println(s.strToInt("- "));//0
        System.out.println(s.strToInt(" 2"));//2
        System.out.println(s.strToInt(" 3 "));//3
        System.out.println(s.strToInt(" -3 "));//-3
        System.out.println(s.strToInt("2147483649"));//Integer.MAX_VALUE
        System.out.println(s.strToInt("-2147483649"));//Integer.MAX_VALUE
        System.out.println(s.strToInt("2147483646"));
        System.out.println(s.strToInt("-2147483647"));
        System.out.println(s.strToInt("-2147483648"));
        System.out.println(s.strToInt("-2147483649"));


    }
}
