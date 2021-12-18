package com.github.algo.base.solution.base;

public class Utils {
    public static int[] createArray(String s) {
        String[] split = s.replace("[", "").replace("]", "").split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }
}
