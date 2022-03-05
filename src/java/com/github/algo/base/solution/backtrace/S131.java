package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.List;

public class S131 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrace(s, 0, new ArrayList<>());
        return res;
    }

    private void backTrace(String s, int start, List<String> path) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backTrace(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        int i = start, j = end;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
