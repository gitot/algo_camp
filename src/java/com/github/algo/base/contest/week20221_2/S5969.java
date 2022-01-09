package com.github.algo.base.contest.week20221_2;

import sun.rmi.runtime.Log;

import java.util.Arrays;

public class S5969 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (m < asteroids[i]) return false;
            m += asteroids[i];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
}
