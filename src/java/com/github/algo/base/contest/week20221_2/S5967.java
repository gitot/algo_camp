package com.github.algo.base.contest.week20221_2;

public class S5967 {
    public boolean checkString(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == 'b' && charArray[i + 1] == 'a') return false;
        }
        return true;
    }
}
