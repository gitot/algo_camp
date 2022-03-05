package com.github.algo.base.solution.backtrace;

import java.util.*;

public class S46 {
    List<List<Integer>> res = new ArrayList<>();
    private int length;

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> options = new LinkedList<>();
        for (int num : nums) {
            options.add(num);
        }
        this.length = nums.length;
        backTrace(nums, 0, new ArrayList<>());
        return res;
    }

    private void backTrace(int[] nums, int i, List<Integer> path) {
        if (i >= length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            backTrace(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
