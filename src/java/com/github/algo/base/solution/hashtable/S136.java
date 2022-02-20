package com.github.algo.base.solution.hashtable;

import java.util.HashMap;
import java.util.Map;

public class S136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                map.put(num, integer + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue().equals(1)) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }
}
