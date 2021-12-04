package com.github.algo.base.solution.base;

public class S344 {

    public void reverseString(char[] s) {
        int lf = 0; //left pointer
        int rig = s.length - 1; //right pointer

        //swap values on two pointers from end to medium
        while (lf < rig) {
            char tmp = s[lf];
            s[lf] = s[rig];
            s[rig] = tmp;

            lf++;
            rig--;
        }
    }
}
