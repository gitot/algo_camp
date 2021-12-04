package com.github.algo.base.solution.base;

import java.util.HashMap;
import java.util.Map;

public class S1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            for (int right = left + 1; right < len; right++) {
                if (nums[right] == target - nums[left]) {
                    //return directly once find the answer
                    int[] res = new int[2];
                    res[0] = left;
                    res[1] = right;
                    return res;
                }
            }
        }
        return new int[0];
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        map.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                int[] res = new int[2];
                res[0] = map.get(left);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        new S1().twoSum2(nums, target);
    }


}
