package com.github.algo.base.solution.patttern;


public class SInterview16_11 {


    /**
     * a*shorter + (k-a)*longer         a:[0,k]
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        //there is only one possible length
        //if shorter == longer
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] res = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            res[i] = i * longer + (k - i) * shorter;
        }
        return res;
    }


    public static void main(String[] args) {
    }

}
