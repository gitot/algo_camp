package com.github.algo.base.solution.hashtable;

import java.util.HashMap;
import java.util.Map;

public class S1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            int reminder = target - nums[i];
            if (map.containsKey(reminder) && i != map.get(reminder)) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        return null;
    }
}
