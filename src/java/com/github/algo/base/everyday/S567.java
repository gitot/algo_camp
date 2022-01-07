package com.github.algo.base.everyday;

import java.util.Arrays;

/**
 * Why confuse '>' with '<'?
 * It seems very stupid to make such mistakes.
 */
public class S567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int a = s1.length();
        int b = s2.length();

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < a; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = a; i < b; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - a) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }
}
