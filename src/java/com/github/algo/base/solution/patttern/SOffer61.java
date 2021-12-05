package com.github.algo.base.solution.patttern;

import java.util.Arrays;

public class SOffer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        //count of zero at the beginning
        int cnt = 0;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == 0) {
                cnt++;
                continue;
            }
            int gap = nums[i + 1] - nums[i];
            if (gap == 0) {// there is duplicated number in array
                return false;
            } else {
                cnt -= (gap - 1);
                if (cnt < 0) return false;
            }
        }
        return cnt >= 0;
    }

    public static void main(String[] args) {
        //[0,0,0,0,0]  t
    }
}
