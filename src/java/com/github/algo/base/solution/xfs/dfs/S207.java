package com.github.algo.base.solution.xfs.dfs;

import java.util.*;

public class S207 {



    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!graph.containsKey(prerequisite[1])) {
                graph.put(prerequisite[1], new LinkedList());
            }
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }


        int[] inDegrees = new int[numCourses];
        for (Map.Entry<Integer, LinkedList<Integer>> entry : graph.entrySet()) {
            LinkedList<Integer> list = entry.getValue();
            for (Integer course : list) {
                inDegrees[course]++;
            }
        }

        Queue<Integer> zeroInDegrees = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) zeroInDegrees.add(i);
        }

        int visited = 0;

        while (!zeroInDegrees.isEmpty()) {
            Integer poll = zeroInDegrees.poll();
            visited++;
            LinkedList<Integer> list = graph.get(poll);
            if (list == null || list.size() == 0) {
                continue;
            }
            for (Integer integer : list) {
                inDegrees[integer]--;
                if (inDegrees[integer] == 0) {
                    zeroInDegrees.offer(integer);
                }
            }
        }

        return visited >= numCourses;
    }


    public static void main(String[] args) {
        new S207().canFinish(2, new int[][]{{0, 1}});
    }

}
