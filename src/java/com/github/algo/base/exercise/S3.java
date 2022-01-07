package com.github.algo.base.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * Find a pattern yourself.
 */
public class S3 {
    public int lengthOfLongestSubstring(String s) {

        int length = s.length();
        Set<Character> set = new HashSet<>();
        int r = -1;
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }

            while (r + 1 < length && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }

            res = Math.max(res, r - i + 1);
        }


        return res;
    }
}
