package com.github.algo.base.solution.hashtable;

import java.util.*;

public class S49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String groupKey = new String(chars);
            if (map.containsKey(groupKey)) {
                map.get(groupKey).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                map.put(groupKey, newGroup);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            res.add(stringListEntry.getValue());
        }
        return res;
    }

}
