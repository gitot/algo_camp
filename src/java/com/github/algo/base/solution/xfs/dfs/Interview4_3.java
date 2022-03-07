package com.github.algo.base.solution.xfs.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Interview4_3 {

    boolean found;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!map.containsKey(graph[i][0])) {
                map.put(graph[i][0], new LinkedList<>());
            }
            map.get(graph[i][0]).add(graph[i][1]);
        }

        dfs(map,visited,start, target);

        return found;
    }

    private void dfs(Map<Integer, LinkedList<Integer>> map,boolean[] visited, int start, int target) {
        if (start == target) {
            found = true;
            visited[start] = true;
            return;
        }

        LinkedList<Integer> nodes = map.get(start);
        if (nodes == null) {
            return;
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (visited[nodes.get(i)]) {
                continue;
            }
            dfs(map, visited, nodes.get(i), target);
        }

    }


}
