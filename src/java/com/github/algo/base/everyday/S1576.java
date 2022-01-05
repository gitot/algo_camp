package com.github.algo.base.everyday;

public class S1576 {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            if (chars[i] != '?') {
                continue;
            }

            //replace '?'
            for (char ch = 'a'; ch <= 'c'; ch++) {
                if (i > 0 && chars[i - 1] == ch) {
                    continue;
                }
                if (i < len - 1 && chars[i + 1] == ch) {
                    continue;
                }
                chars[i] = ch;
                break;
            }
        }

        return new String(chars);
    }
}
