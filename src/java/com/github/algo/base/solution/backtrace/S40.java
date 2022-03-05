package com.github.algo.base.solution.backtrace;

import java.util.*;

public class S40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int candidate : candidates) {
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }
        int[] nums = new int[map.size()];
        int[] numCount = new int[map.size()];
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry<Integer, Integer> next = iterator.next();
            nums[i] = next.getKey();
            numCount[i] = next.getValue();
        }
        backTrace(nums, numCount, 0, new ArrayList<>(), 0, target);
        return res;
    }

    private void backTrace(int[] nums, int[] numCount, int p, List<Integer> path, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        if (p >= nums.length) {
            return;
        }


        for (int i = 0; i <= numCount[p]; i++) {
            for (int k = 0; k < i; k++) {
                path.add(nums[p]);
                sum += nums[p];
            }
            backTrace(nums, numCount, p + 1, path, sum, target);
            boolean end = false;
            if (sum >= target) {
                end = true;
            }
            for (int k = 0; k < i; k++) {
                path.remove(path.size() - 1);
                sum -= nums[p];
            }
            if (end) return;
        }

    }
}
