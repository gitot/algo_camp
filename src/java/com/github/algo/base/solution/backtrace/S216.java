package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.List;

public class S216 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrace(1, new ArrayList<>(), 0, k, n);
        return res;
    }

    private void backTrace(int num, List<Integer> path, int sum, int k, int n) {
        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > n) {
            return;
        }
        if (path.size() >= k) {
            return;
        }
        if (num > 9) {
            return;
        }

        backTrace(num + 1, path, sum, k, n);
        path.add(num);
        sum += num;
        backTrace(num + 1, path, sum, k, n);
        path.remove(path.size() - 1);
    }
}
