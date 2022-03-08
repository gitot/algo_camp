package com.github.algo.base.solution.xfs.dfs;

public class S1306 {
    boolean canReach;

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        dfs(visited, arr, start);
        return canReach;
    }

    private void dfs(boolean[] visited, int[] arr, int start) {
        if (visited[start]) {
            return;
        }
        if (arr[start] == 0) {
            canReach = true;
            return;
        }
        visited[start] = true;
        int next = start + arr[start];
        if (next >= 0 && next < arr.length && !visited[next]) {
            dfs(visited, arr, next);
        }
        next = start - arr[start];
        if (next >= 0 && next < arr.length && !visited[next]) {
            dfs(visited, arr, next);
        }
    }
}
