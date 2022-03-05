package com.github.algo.base.solution.backtrace;

import java.util.*;

public class S90 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        int[] uniqueNum = new int[numCount.size()];
        int[] uniqueNumTimes = new int[numCount.size()];
        Iterator<Map.Entry<Integer, Integer>> iterator = numCount.entrySet().iterator();
        for (int i = 0; i < numCount.size(); i++) {
            Map.Entry<Integer, Integer> next = iterator.next();
            uniqueNum[i] = next.getKey();
            uniqueNumTimes[i] = next.getValue();
        }

        backTrace(uniqueNum, uniqueNumTimes, 0, new ArrayList<>());

        return res;
    }

    private void backTrace(int[] uniqueNum, int[] uniqueNumTimes, int i, List<Integer> path) {
        if (i >= uniqueNum.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int k = 0; k <= uniqueNumTimes[i]; k++) {
            for (int j = 0; j < k; j++) {
                path.add(uniqueNum[i]);
            }
            backTrace(uniqueNum, uniqueNumTimes, i + 1, path);
            for (int j = 0; j < k; j++) {
                path.remove(path.size() - 1);
            }
        }
    }
}
