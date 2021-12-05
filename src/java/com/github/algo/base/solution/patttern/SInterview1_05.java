package com.github.algo.base.solution.patttern;


public class SInterview1_05 {

    public boolean oneEditAway(String first, String second) {
        int abs = Math.abs(first.length() - second.length());
        if (abs > 1) {
            return false;
        }

        char[] fir = first.toCharArray();
        char[] sec = second.toCharArray();
        if (abs == 0) {
            //return false if there is more than 2 different char
            int cnt = 0;
            for (int i = 0; i < fir.length; i++) {
                if (fir[i] != sec[i]) {
                    cnt += 1;
                    if (cnt > 1) {
                        return false;
                    }

                }
            }
        } else {
            //make fir shorter than sec
            //for convenience for subsequent process
            if (fir.length > sec.length) {
                char[] tmp = fir;
                fir= sec;
                sec = tmp;
            }

            for (int i = 0; i < fir.length; i++) {
                if (fir[i] == sec[i]) {
                    continue;
                }
                if (fir[i] != sec[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

}
