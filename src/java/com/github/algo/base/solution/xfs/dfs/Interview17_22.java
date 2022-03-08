package com.github.algo.base.solution.xfs.dfs;

import java.util.*;

public class Interview17_22 {
    List<String> res = new ArrayList<>();
    private boolean found;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> path = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfs(visited, wordList, beginWord, path, endWord);
        if (res.get(res.size() - 1).equals(endWord)) {
            return res;
        }
        return new ArrayList<>();
    }

    private void dfs(Set<String> visited, List<String> wordList, String cur, List<String> path, String endWord) {
        if (found) return;
        path.add(cur);
        visited.add(cur);
        if (cur.equals(endWord)) {
            found = true;
            res.addAll(path);
            return;
        }
        //find all nodes that are differentiated with 'cur' by only one letter,
        //then perform DFS on them
        for (String s : wordList) {
            int gap = calculateGap(s, cur);
            if (!visited.contains(s) && gap == 1) {
                dfs(visited, wordList, s, path, endWord);
            }
        }
        path.remove(path.size() - 1);
    }

    private int calculateGap(String s, String step) {
        int gap = 0;
        for (int i = 0; i < s.length(); i++) {
            if (step.charAt(i) != s.charAt(i)) {
                gap++;
            }
        }
        return gap;
    }

}
