package com.github.algo.base.contest.week20221_2;

public class S5968 {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int[] devicesAtRow = new int[bank.length];

        for (int i = 0; i < bank.length; i++) {
            String s = bank[i];
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == '1') devicesAtRow[i]++;
            }
        }

        for (int i = 0; i < devicesAtRow.length; i++) {
            if (devicesAtRow[i] <= 0) continue;
            for (int j = i + 1; j < devicesAtRow.length; j++) {
                if (devicesAtRow[j] > 0) {
                    res += devicesAtRow[i] * devicesAtRow[j];
                    break;
                }
            }
        }

        return res;
    }
}
