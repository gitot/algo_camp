package com.github.algo.base.solution.backtrace;

import java.util.ArrayList;
import java.util.List;

public class S78 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void backTrace(int[] nums, int i, List<Integer> path) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        backTrace(nums, i + 1, path);
        path.add(nums[i]);
        backTrace(nums, i + 1, path);
        path.remove(path.size() - 1);
    }
}
