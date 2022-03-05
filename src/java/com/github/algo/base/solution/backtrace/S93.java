package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.List;

public class S93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrace(s, 0, new ArrayList<>());
        return res;
    }

    private void backTrace(String s, int i, List<Integer> path) {
        if (i >= s.length()) {
            if (path.size() == 4) {
                StringBuilder answer = new StringBuilder();
                for (Integer s1 : path) {
                    answer.append(s1);
                    answer.append(".");
                }
                answer.replace(answer.length() - 1, answer.length(), "");
                res.add(answer.toString());
            }
            return;
        }

        int val = 0;
        if (i < s.length()) {
            val = val * 10 + (s.charAt(i) - '0');
            path.add(val);
            backTrace(s, i + 1, path);
            path.remove(path.size() - 1);
        }

        if (s.charAt(i) == '0') {
            return;
        }

        if (i + 1 < s.length()) {
            val = val * 10 + (s.charAt(i + 1) - '0');
            path.add(val);
            backTrace(s, i + 2, path);
            path.remove(path.size() - 1);
        }


        if (i + 2 < s.length()) {
            val = val * 10 + (s.charAt(i + 2) - '0');
            if (val <= 255) {
                path.add(val);
                backTrace(s, i + 3, path);
                path.remove(path.size() - 1);
            }
        }

    }
}
