package com.github.algo.base.solution.xfs.dfs;

import java.util.*;


public class S752 {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> deadendsSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendsSet.add(deadend);
        }
        if (deadendsSet.contains(start)) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (target.equals(poll)) {
                    return depth;
                }

                List<String> nodes = genNodes(poll);
                for (String node : nodes) {
                    if (visited.contains(node) || deadendsSet.contains(node)) {
                        continue;
                    }
                    queue.offer(node);
                    visited.add(node);
                }
            }
            depth++;
        }
        return -1;
    }

    private List<String> genNodes(String prev) {
        List<String> res = new ArrayList<>();
        int[] changes = new int[]{-1, 1};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                char[] newNodes = new char[4];
                for (int k = 0; k < i; k++) {
                    newNodes[k] = prev.charAt(k);
                }
                int num = (prev.charAt(i) - '0' + changes[j] + 10) % 10;
                newNodes[i] = String.valueOf(num).charAt(0);
                for (int k = i + 1; k < 4; k++) {
                    newNodes[k] = prev.charAt(k);
                }
                res.add(new String(newNodes));
            }
        }
        return res;
    }
}
