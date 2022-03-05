package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates, 0, new ArrayList<>(), 0, target);
        return res;
    }

    private void backTrace(int[] candidates, int i, List<Integer> path, int sum, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (i >= candidates.length) {
            return;
        }

        int times = 0;
        while (true) {
            for (int k = 0; k < times; k++) {
                path.add(candidates[i]);
                sum += candidates[i];
            }
            backTrace(candidates, i + 1, path, sum, target);
            boolean end = false;
            if (sum >= target) end = true;
            for (int k = 0; k < times; k++) {
                path.remove(path.size() - 1);
                sum -= candidates[i];
            }
            if (end) return;

            times++;
        }
    }
}
