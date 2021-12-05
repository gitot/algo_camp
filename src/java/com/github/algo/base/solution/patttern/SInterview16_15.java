package com.github.algo.base.solution.patttern;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SInterview16_15 {


    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> s = new HashMap<>();
        Map<Character, Integer> g = new HashMap<>();

        int[] res = new int[2];
        int len = solution.length();
        for (int i = 0; i < len; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                res[0] += 1;
            } else {
                addTimes(s, solution.charAt(i));
                addTimes(g, guess.charAt(i));
            }
        }

        for (Map.Entry<Character, Integer> entry : s.entrySet()) {
            Integer gg = g.get(entry.getKey());
            if (gg == null) continue;
            res[1] += (gg > entry.getValue() ? entry.getValue() : gg);

        }

        return res;
    }

    private void addTimes(Map<Character, Integer> m, char charAt) {
        Integer integer = m.get(charAt);
        integer = integer == null ? 0 : integer;
        m.put(charAt, integer + 1);
    }

    public static void main(String[] args) {
        SInterview16_15 s = new SInterview16_15();
        int[] ints = s.masterMind("RGRB", "BBBY");
        System.out.println(Arrays.toString(ints));
    }

}
