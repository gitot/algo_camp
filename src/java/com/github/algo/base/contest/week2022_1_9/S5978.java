package com.github.algo.base.contest.week2022_1_9;

import java.util.Arrays;

public class S5978 {
    public int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        for (String targetWord : targetWords) {
            if (canTransform(startWords, targetWord)) {
                res++;
            }
        }
        return res;
    }

    private boolean canTransform(String[] startWords, String targetWord) {
        for (String startWord : startWords) {
            if (canTransform(startWord, targetWord)) {
                return true;
            }
        }
        return false;
    }

    private boolean canTransform(String startWord, String targetWord) {
        if (startWord.length() + 1 != targetWord.length()) {
            return false;
        }

        char[] startArray = startWord.toCharArray();
        char[] targetArray = targetWord.toCharArray();
        int startLength = startArray.length;
        Arrays.sort(startArray);
        Arrays.sort(targetArray);
        for (int i = 0; i < startLength; i++) {
            if (startArray[i] != targetArray[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] startWords = new String[]{"ant","act","tack"};

        String[] targetWords = new String[]{"tack","act","acti"};
        int i = new S5978().wordCount(startWords, targetWords);
        System.out.println();
    }
}
