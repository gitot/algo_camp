package com.github.algo.base.solution.hashtable;

import java.util.*;

public class S15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < len; j++) {
                if (j != i + 1 && nums[j] == nums[j-1]) continue;
                int reminder = 0 - nums[i] - nums[j];
                if (map.containsKey(reminder) && map.get(reminder) > j) {
                    res.add(Arrays.asList(nums[i], nums[j], reminder));
                }
            }
        }

        return res;
    }

}
