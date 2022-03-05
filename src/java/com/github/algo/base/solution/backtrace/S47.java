package com.github.algo.base.solution.backtrace;

import java.util.*;

public class S47 {

    List<List<Integer>> res = new ArrayList<>();
    private int length;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] uniqueNums = new int[map.size()];
        int[] uniqueNumTimes = new int[map.size()];
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry<Integer, Integer> next = iterator.next();
            uniqueNums[i] = next.getKey();
            uniqueNumTimes[i] = next.getValue();
        }

        backTrace(uniqueNums, uniqueNumTimes, 0, new ArrayList<>());

        return res;
    }

    private void backTrace(int[] uniqueNum, int[] uniqueNumTimes, int i, List<Integer> path) {
        if (i >= length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int k = 0; k < uniqueNum.length; k++) {
            if (uniqueNumTimes[k] <= 0) {
                continue;
            }
            path.add(uniqueNum[k]);
            uniqueNumTimes[k]--;
            backTrace(uniqueNum, uniqueNumTimes, i + 1, path);
            path.remove(path.size() - 1);
            uniqueNumTimes[k]++;
        }
    }
}
