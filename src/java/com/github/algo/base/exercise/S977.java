package com.github.algo.base.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * This question can be solved by dual-pointer solution.
 * Give a try one day in the future.
 * todo
 */
public class S977 {
    public int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;

        //非正数的右边界
        int right = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                list.add(0);
                right = i;
            } else if (nums[i] > 0) {
                right = i - 1;
                break;
            } else if (i == len - 1) {
                right = i;
            }
        }

        //负数部分的最后一个位置
        int left = right - list.size();
        right++;

        while (left >= 0 && right < len) {
            int l = Math.abs(nums[left]);
            int r = Math.abs(nums[right]);
            if (l > r) {
                list.add(r * r);
                right++;
            } else if (l < r) {
                list.add(l * l);
                left--;
            } else {
                list.add(l * l);
                list.add(l * l);
                left--;
                right++;
            }
        }

        if (left >= 0) {
            for (int i = left; i >= 0; i--) {
                int abs = Math.abs(nums[i]);
                list.add(abs * abs);
            }
        } else {
            for (int i = right; i < len; i++) {
                int abs = Math.abs(nums[i]);
                list.add(abs * abs);
            }
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
