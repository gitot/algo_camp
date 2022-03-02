package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.List;

public class S77 {

    List<List<Integer>> res = new ArrayList<>();
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        List<Integer> path = new ArrayList<>();
        backTrace(n, 1, path);
        return res;
    }

    private void backTrace(int n, int i, List<Integer> path) {
        if (path.size() >= k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (i == n + 1) {
            return;
        }

        backTrace(n, i + 1, path);
        path.add(i);
        backTrace(n, i + 1, path);
        path.remove(path.size() - 1);
    }
}
